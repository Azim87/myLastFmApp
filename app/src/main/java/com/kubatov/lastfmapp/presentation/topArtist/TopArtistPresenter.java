package com.kubatov.lastfmapp.presentation.topArtist;

import android.util.Log;

import com.kubatov.lastfmapp.data.artist.IArtistRepository;
import com.kubatov.lastfmapp.entities.ArtistEntity;

import java.util.List;

import core.mvp.CoreMvpPresenter;

public class TopArtistPresenter extends CoreMvpPresenter<ITopArtistContract.View>
        implements ITopArtistContract.Presenter {

    private IArtistRepository repository;

    public TopArtistPresenter(IArtistRepository repository){
        this.repository = repository;
    }

    @Override
    public void getArtist() {
        repository.getArtists(new IArtistRepository.ArtistCallBack() {
            @Override
            public void onSuccess(List<ArtistEntity> artist) {
                Log.d("ololo", "onSuccess" + artist.size());
                if (view !=null){
                    view.showArtist(artist);
                }
            }

            @Override
            public void onFailure(String message) {
                Log.d("ololo", "onFailure" + message);
                if (view !=null){
                    view.showMessage(message);
                }
            }
        });

    }

    @Override
    public void onArtistClick(int position) {

    }
}
