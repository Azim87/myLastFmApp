package com.kubatov.lastfmapp.data.tracks.remote.modelTracks;

import com.google.gson.annotations.SerializedName;
import com.kubatov.lastfmapp.entities.TrackEntity;

import java.util.List;

public class TracksResponseData {

    @SerializedName("track")
    private List<TrackEntity> data;

    public TracksResponseData(List<TrackEntity> data) {
        this.data = data;
    }

    public List<TrackEntity> getData() {
        return data;
    }

    public void setData(List<TrackEntity> data) {
        this.data = data;
    }
}
