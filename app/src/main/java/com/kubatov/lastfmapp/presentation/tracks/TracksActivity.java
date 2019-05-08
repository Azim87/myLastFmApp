package com.kubatov.lastfmapp.presentation.tracks;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kubatov.lastfmapp.R;
import com.kubatov.lastfmapp.entities.ArtistEntity;
import com.kubatov.lastfmapp.presentation.artist.IArtistContract;

import java.util.ArrayList;

import core.mvp.CoreMvpActivity;
import core.mvp.ICoreMvpContract;

public class TracksActivity extends CoreMvpActivity<IArtistContract.Presenter>
        implements IArtistContract.View {


    @Override
    public void showArtist(ArrayList<ArtistEntity> artistEntity) {

    }

    @Override
    public void openArtistDetails(ArtistEntity artist) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tracks;
    }

    @Nullable
    @Override
    protected void initView() {

    }

    @Nullable
    @Override
    protected IArtistContract.Presenter providePresenter() {
        return null;
    }
}
