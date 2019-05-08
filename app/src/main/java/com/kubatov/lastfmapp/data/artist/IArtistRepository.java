package com.kubatov.lastfmapp.data.artist;

import com.kubatov.lastfmapp.entities.ArtistEntity;

import java.util.List;

public interface IArtistRepository {

    ArtistEntity getArtist(int id);

    void getArtists(ArtistCallBack callBack);

    public interface ArtistCallBack {

        void onSuccess(List<ArtistEntity> artist);

        void onFailure(String message);
    }
}
