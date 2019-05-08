package com.kubatov.lastfmapp.presentation.topArtist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.kubatov.lastfmapp.App;




public class TopArtistActivity extends AppCompatActivity {

    ITopArtistContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TopArtistsFragment artistsFragment = TopArtistsFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, artistsFragment)
                .commit();

        mPresenter = new TopArtistPresenter(App.artistRepository);
        mPresenter.attachView(artistsFragment);
        mPresenter.getArtist();
        Log.d("ololo", "artist activity");

    }
}
