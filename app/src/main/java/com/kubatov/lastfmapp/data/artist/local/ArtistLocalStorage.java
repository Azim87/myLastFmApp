package com.kubatov.lastfmapp.data.artist.local;

import com.kubatov.lastfmapp.data.artist.IArtistRepository;
import com.kubatov.lastfmapp.entities.ArtistEntity;

import java.util.ArrayList;
import java.util.List;

public class ArtistLocalStorage implements IArtistLocalStorage {
    @Override
    public void getArtists(IArtistRepository.ArtistCallBack callback) {
        ArrayList<ArtistEntity> arrayList = new ArrayList<>();
        callback.onSuccess(arrayList);
    }

    @Override
    public void setArtists(List<ArtistEntity> artists) {

    }
}
