package com.kubatov.lastfmapp.entities;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrackEntity  {

    @SerializedName("name")
    private String name;

    @SerializedName("artist")
    private  ArtistEntity artist;

    @SerializedName("url")
    private String url;

    @SerializedName("playcount")
    private String playcount;

    @SerializedName("listeners")
    private String listeners;

    @SerializedName("image")
    private List<ArtistImage> image;

    public TrackEntity(String name, ArtistEntity artist, String url, String playcount, String listeners, List<ArtistImage> image) {
        this.name = name;
        this.artist = artist;
        this.url = url;
        this.playcount = playcount;
        this.listeners = listeners;
        this.image = image;
    }

    //region Getters/Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistEntity getArtist() {
        return artist;
    }

    public void setArtist(ArtistEntity artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public List<ArtistImage> getImage() {
        return image;
    }

    public void setImage(List<ArtistImage> image) {
        this.image = image;
    }

    //endregion

    public String getUniqueId(){
        return name + " " + artist.getName();
    }

    @NonNull
    @Override
    public String toString() {
        return  name + " " + artist + " " + image;
    }
}
