package com.kubatov.lastfmapp.data.tracks.local;

import com.kubatov.lastfmapp.data.tracks.ITrackRepository;
import com.kubatov.lastfmapp.entities.TrackEntity;

import java.util.List;

public interface ITrackLocalStorage {

    void getTracks(ITrackRepository.TracksCallback callback);

    void setTracks(List<TrackEntity> tracks);
}
