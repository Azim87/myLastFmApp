package com.kubatov.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.kubatov.lastfmapp.data.tracks.local.ITrackLocalStorage;
import com.kubatov.lastfmapp.data.tracks.remote.ITrackRemoteStorage;
import com.kubatov.lastfmapp.entities.TrackEntity;

import java.util.List;

public class TrackRepository implements ITrackRepository {

    @Nullable
    private ITrackLocalStorage localStorage;

    @Nullable
    private ITrackRemoteStorage remoteStorage;

    public TrackRepository(@Nullable ITrackLocalStorage localStorage,
                           @Nullable ITrackRemoteStorage remoteStorage) {

        this.localStorage = localStorage;
        this.remoteStorage = remoteStorage;
    }

    @Override
    public TrackEntity getTrack(int id) {
        return null;
    }

    @Override
    public void getTracks(final TracksCallback callback) {

        if (localStorage !=null){
            localStorage.getTracks(callback);
        }

        if (remoteStorage !=null){
            remoteStorage.getTracks(new TracksCallback() {
                @Override
                public void onSuccess(List<TrackEntity> tracks) {
                    localStorage.setTracks(tracks);
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
