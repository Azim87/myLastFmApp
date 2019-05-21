package com.kubatov.lastfmapp.data.tracks;

import com.kubatov.lastfmapp.entities.TrackEntity;

import java.util.List;

public interface ITrackRepository {

    TrackEntity getTrack(String uniqueId);

    void getTracks(TracksCallback callback);

    public interface TracksCallback {

        void onSuccess(List<TrackEntity> tracks);

        void onFailure(String message);
    }
}
