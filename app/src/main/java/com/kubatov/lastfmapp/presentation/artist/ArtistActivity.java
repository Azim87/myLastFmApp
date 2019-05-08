package com.kubatov.lastfmapp.presentation.artist;


import android.support.annotation.Nullable;

import com.kubatov.lastfmapp.R;
import com.kubatov.lastfmapp.entities.ArtistEntity;

import java.util.ArrayList;

import core.mvp.CoreMvpActivity;


public class ArtistActivity extends CoreMvpActivity<IArtistContract.Presenter>
        implements IArtistContract.View {


    @Override
    public void showArtist(ArrayList<ArtistEntity> artistEntity) {

    }

    @Override
    public void openArtistDetails(ArtistEntity artist) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_artist;
    }

    @Nullable
    @Override
    protected void initView() {

    }

    @Nullable
    @Override
    protected IArtistContract.Presenter providePresenter() {
        return new ArtistPresenter();
    }
}
