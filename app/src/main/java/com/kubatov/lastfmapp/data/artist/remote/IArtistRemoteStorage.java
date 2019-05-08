package com.kubatov.lastfmapp.data.artist.remote;

import com.kubatov.lastfmapp.data.artist.IArtistRepository;

public interface IArtistRemoteStorage {
    void getArtists(IArtistRepository.ArtistCallBack callBack);
}
