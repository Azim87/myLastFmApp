package com.kubatov.lastfmapp.presentation.topTracks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
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
import java.util.ArrayList;
import java.util.List;
import core.mvp.CoreMvpFragment;

public class TopTracksFragment
        extends CoreMvpFragment<ITopTracksContract.Presenter>
        implements ITopTracksContract.View {

    TopTracksAdapter mAdapter;
    RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefresh;

    public static TopTracksFragment newInstance() {

        TopTracksFragment tracksFragment = new TopTracksFragment();
        return tracksFragment;
    }

    @Override
    protected void initView(View view) {
        mRecyclerView = view.findViewById(R.id.tracks_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new TopTracksAdapter(getContext(),
                new ArrayList<>(), position -> {
                    if (presenter != null) {
                        presenter.onTracksClick(position);
                    }
                });
        mRecyclerView.setAdapter(mAdapter);
        mRefresh = view.findViewById(R.id.refresh_top_tracks);
        mRefresh.setOnRefreshListener(() -> {
            Log.d("ololo", "refresh ");
            refreshTracks();
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_top_track;
    }

    public void refreshTracks() {
        if (presenter != null) {
            presenter.getTracks();
        }
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
        if (getActivity() != null) {
            TracksActivity.start(getActivity(), track.getUniqueId());
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startRefresh() {
        Toast.makeText(getContext(), "Updated!", Toast.LENGTH_SHORT).show();
        Log.d("ololo", " on Start " + mRefresh.toString());
        if (mRefresh != null) {
            mRefresh.setRefreshing(true);
        }
    }

    @Override
    public void endRefresh() {
        if (mRefresh != null) {
            mRefresh.setRefreshing(false);
        }
    }
}
