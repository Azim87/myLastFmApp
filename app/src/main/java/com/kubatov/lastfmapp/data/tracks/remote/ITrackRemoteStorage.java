package com.kubatov.lastfmapp.data.tracks.remote;

import com.kubatov.lastfmapp.data.tracks.ITrackRepository;

public interface ITrackRemoteStorage {
    void getTracks(ITrackRepository.TracksCallback callback);
}
