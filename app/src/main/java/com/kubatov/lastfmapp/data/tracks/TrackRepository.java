package com.kubatov.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.kubatov.lastfmapp.data.tracks.local.ITrackLocalStorage;
import com.kubatov.lastfmapp.data.tracks.remote.ITrackRemoteStorage;
import com.kubatov.lastfmapp.entities.TrackEntity;

import java.util.HashMap;
import java.util.List;

public class TrackRepository implements ITrackRepository {

    @Nullable
    private ITrackLocalStorage localStorage;
    @Nullable
    private ITrackRemoteStorage remoteStorage;

    private HashMap<String, TrackEntity> mCache = new HashMap<>();

    public TrackRepository(@Nullable ITrackLocalStorage localStorage,
                           @Nullable ITrackRemoteStorage remoteStorage) {

        this.localStorage = localStorage;
        this.remoteStorage = remoteStorage;
    }

    private void setCache(List<TrackEntity> tracks) {
        if (localStorage != null) {
            localStorage.setTracks(tracks);
        }

        for (TrackEntity track : tracks) {
            mCache.put(track.getUniqueId(), track);
        }
    }

    @Nullable
    @Override
    public TrackEntity getTrack(String uniqueId) {
        TrackEntity track = mCache.get(uniqueId);
        if (track == null && localStorage == null) {
            track = localStorage.getTrack();
        }
        return track;
    }

    @Override
    public void getTracks(final TracksCallback callback) {

        if (localStorage != null) {
            localStorage.getTracks(callback);
        }

        if (remoteStorage != null) {
            remoteStorage.getTracks(new TracksCallback() {
                @Override
                public void onSuccess(List<TrackEntity> tracks) {
                    setCache(tracks);
                    callback.onSuccess(tracks);
                }

                @Override
                public void onFailure(String message) {
                    callback.onFailure(message);
                }
            });
        }
    }
}
