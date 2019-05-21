package com.kubatov.lastfmapp.presentation.artist;


import android.support.annotation.Nullable;
import android.widget.TextView;

import com.kubatov.lastfmapp.R;
import com.kubatov.lastfmapp.entities.ArtistEntity;

import java.util.ArrayList;

import core.mvp.CoreMvpActivity;


public class ArtistActivity extends CoreMvpActivity<IArtistContract.Presenter>
        implements IArtistContract.View {

    private TextView artistView;

    @Override
    public void showArtist(ArtistEntity artistEntity) {

    }

    @Override
    public void openArtistDetails(ArtistEntity artist) {
        artistView.setText(artist.getName());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_artist;
    }

    @Nullable
    @Override
    protected void initView() {
        artistView = findViewById(R.id.artist_view);
    }

    @Nullable
    @Override
    protected IArtistContract.Presenter providePresenter() {
        return new ArtistPresenter();
    }
}
