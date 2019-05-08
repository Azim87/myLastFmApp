package com.kubatov.lastfmapp.data.tracks;

import com.kubatov.lastfmapp.entities.TrackEntity;

import java.util.List;

public interface ITrackRepository {

    TrackEntity getTrack(int id);

    void getTracks(TracksCallback callback);

    public interface TracksCallback {

        void onSuccess(List<TrackEntity> tracks);

        void onFailure(String message);
    }
}
