package com.kubatov.lastfmapp.data.artist.local;

import com.kubatov.lastfmapp.data.artist.IArtistRepository;
import com.kubatov.lastfmapp.entities.ArtistEntity;

import java.util.List;

public interface IArtistLocalStorage {

    void getArtists(IArtistRepository.ArtistCallBack callback);

    void setArtists(List<ArtistEntity> artists);
}
