package com.kubatov.lastfmapp.data.artist;

import android.support.annotation.Nullable;

import com.kubatov.lastfmapp.data.artist.local.IArtistLocalStorage;
import com.kubatov.lastfmapp.data.artist.remote.ArtistRemoteStorage;
import com.kubatov.lastfmapp.data.artist.remote.IArtistRemoteStorage;
import com.kubatov.lastfmapp.entities.ArtistEntity;

import java.util.List;

public class ArtistRepository implements IArtistRepository {

    @Nullable
    private IArtistLocalStorage localStorage;
    @Nullable
    private IArtistRemoteStorage remoteStorage;

    public ArtistRepository(@Nullable IArtistLocalStorage localStorage,
                            @Nullable ArtistRemoteStorage remoteStorage) {
        this.localStorage = localStorage;
        this.remoteStorage = remoteStorage;
    }

    @Override
    public ArtistEntity getArtist(int id) {
        return null;
    }

    @Override
    public void getArtists(final ArtistCallBack callBack) {

        localStorage.getArtists(callBack);

        remoteStorage.getArtists(new ArtistCallBack() {
            @Override
            public void onSuccess(List<ArtistEntity> artist) {
                localStorage.setArtists(artist);
                callBack.onSuccess(artist);
            }

            @Override
            public void onFailure(String message) {
                callBack.onFailure(message);
            }
        });
    }
}
