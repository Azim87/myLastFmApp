package com.kubatov.lastfmapp.data.artist.remote.modelArtist;

import com.google.gson.annotations.SerializedName;
import com.kubatov.lastfmapp.entities.ArtistEntity;

import java.util.List;

public class ArtistResponseData {

    @SerializedName("artist")
   private List<ArtistEntity> artist;

    public List<ArtistEntity> getArtist() {
        return artist;
    }

    public void setArtist(List<ArtistEntity> artist) {
        this.artist = artist;
    }

    public ArtistResponseData(List<ArtistEntity> artist) {
        this.artist = artist;
    }
}
