package com.kubatov.lastfmapp.presentation.topTracks;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.kubatov.lastfmapp.R;
import com.kubatov.lastfmapp.entities.TrackEntity;
import com.kubatov.lastfmapp.presentation.topTracks.adapter.TopTrackViewHolder;
import com.kubatov.lastfmapp.presentation.topTracks.adapter.TopTracksAdapter;
import com.kubatov.lastfmapp.presentation.tracks.TracksActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import core.mvp.CoreMvpFragment;

public class TopTracksFragment
        extends CoreMvpFragment<ITopTracksContract.Presenter>
        implements ITopTracksContract.View {

    TopTracksAdapter mAdapter;
    RecyclerView mRecyclerView;
    ArrayList<TrackEntity> tracks;

    public static TopTracksFragment newInstance() {

        TopTracksFragment tracksFragment = new TopTracksFragment();
        return tracksFragment;
    }

    @Override
    protected void initView(View view) {
        tracks = new ArrayList<>();
        mRecyclerView = view.findViewById(R.id.tracks_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new TopTracksAdapter(getContext(), new ArrayList<TrackEntity>(), new TopTrackViewHolder.TopTrackClickListener() {
            @Override
            public void onTrackClick(int position) {
                if (presenter != null){
                    presenter.onTrackClick(position);
                }
                Intent intent = new Intent(getContext(), TracksActivity.class);
                intent.putExtra("tracks", tracks);
                startActivity(intent);
            }

            @Override
            public void onShareClick(int position) {

            }

            @Override
            public void onBookmarkClick(int position) {

            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_top_track;
    }

    @Override
    public void showTracks(List<TrackEntity> tracks) {
        for (TrackEntity track : tracks) {
            Log.d("ololo", "on Show tracks " + track.toString());
            mAdapter.setTracks(tracks);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void openTrackDetails(TrackEntity track) {
       /*Intent intent = new Intent(getContext(), TracksActivity.class);
        intent.putExtra("track", (Serializable) track);
        startActivity(intent);*/
    }

    @Override
    public void showMessage(String message) {
    }
}
