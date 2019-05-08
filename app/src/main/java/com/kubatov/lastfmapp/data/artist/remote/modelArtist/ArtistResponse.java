package com.kubatov.lastfmapp.data.artist.remote.modelArtist;

import com.google.gson.annotations.SerializedName;

public class ArtistResponse {

    @SerializedName("artists")
    private ArtistResponseData data;

    public ArtistResponse(ArtistResponseData data) {
        this.data = data;
    }

    public ArtistResponseData getData() {
        return data;
    }

    public void setData(ArtistResponseData data) {
        this.data = data;
    }
}
