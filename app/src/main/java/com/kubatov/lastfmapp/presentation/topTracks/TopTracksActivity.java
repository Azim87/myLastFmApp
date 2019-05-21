package com.kubatov.lastfmapp.presentation.topTracks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kubatov.lastfmapp.App;
import com.kubatov.lastfmapp.R;
import com.kubatov.lastfmapp.entities.TrackEntity;

public class TopTracksActivity extends AppCompatActivity {

    private ITopTracksContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TopTracksFragment fragment = TopTracksFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, fragment)
                .commit();

        mPresenter = new TopTracksPresenter(App.trackRepository);
        mPresenter.attachView(fragment);


    }

}