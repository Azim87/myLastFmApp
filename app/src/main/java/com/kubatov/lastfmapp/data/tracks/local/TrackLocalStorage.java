package com.kubatov.lastfmapp.data.tracks.local;

import com.kubatov.lastfmapp.data.tracks.ITrackRepository;
import com.kubatov.lastfmapp.entities.TrackEntity;

import java.util.ArrayList;
import java.util.List;

public class TrackLocalStorage implements ITrackLocalStorage {
    @Override
    public void getTracks(ITrackRepository.TracksCallback callback) {
        ArrayList<TrackEntity> trackEntities = new ArrayList<>();
        callback.onSuccess(trackEntities);
    }

    @Override
    public void setTracks(List<TrackEntity> tracks) {
    }
}
