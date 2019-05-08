package com.kubatov.lastfmapp.data.tracks.remote.modelTracks;

import com.google.gson.annotations.SerializedName;

public class TracksResponse {

    @SerializedName("tracks")
    private TracksResponseData tracks;

    public TracksResponse(TracksResponseData tracks) {
        this.tracks = tracks;
    }

    public void setTracks(TracksResponseData tracks) {
        this.tracks = tracks;
    }

    public TracksResponseData getTracks() {
        return tracks;
    }
}
