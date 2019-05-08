package com.kubatov.lastfmapp.presentation.topArtist;


import com.kubatov.lastfmapp.entities.ArtistEntity;
import java.util.List;
import core.mvp.ICoreMvpContract;

public interface ITopArtistContract {

    interface View extends ICoreMvpContract.View<Presenter> {

        void showArtist(List<ArtistEntity> artistEntityList);
        void openArtistDetails(ArtistEntity artistEntity);
    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {

        void getArtist();
        void onArtistClick(int position);
    }
}
