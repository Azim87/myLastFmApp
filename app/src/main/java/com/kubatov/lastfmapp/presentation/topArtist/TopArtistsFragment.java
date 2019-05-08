package com.kubatov.lastfmapp.presentation.topArtist;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.kubatov.lastfmapp.R;
import com.kubatov.lastfmapp.entities.ArtistEntity;
import com.kubatov.lastfmapp.presentation.topArtist.adapter.TopArtistAdapter;
import com.kubatov.lastfmapp.presentation.topArtist.adapter.TopArtistViewHolder;


import java.util.ArrayList;
import java.util.List;

import core.mvp.CoreMvpFragment;


public class TopArtistsFragment
        extends CoreMvpFragment<ITopArtistContract.Presenter>
        implements ITopArtistContract.View{

    TopArtistAdapter mAdapter;
    RecyclerView recyclerView;
    private TopArtistViewHolder.TopArtistClickListener mListener;

    public static TopArtistsFragment newInstance(){
        TopArtistsFragment artistsFragment = new TopArtistsFragment();
        return artistsFragment;
    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.artist_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new TopArtistAdapter(getContext(), new ArrayList<ArtistEntity>(), mListener);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_top_artist;
    }

    @Override
    public void showArtist(List<ArtistEntity> artist) {

        for (ArtistEntity artists : artist) {
            Log.d("ololo", "onShow artist " + artists.toString());
            mAdapter.setArtists(artist);
            mAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void openArtistDetails(ArtistEntity artistEntity) {
    }

    @Override
    public void showMessage(String message) {

    }
}
