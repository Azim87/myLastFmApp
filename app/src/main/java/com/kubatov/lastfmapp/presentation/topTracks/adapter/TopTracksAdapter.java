package com.kubatov.lastfmapp.presentation.topTracks.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.kubatov.lastfmapp.R;
import com.kubatov.lastfmapp.entities.TrackEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TopTracksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    private ArrayList<TrackEntity> mTracks;
    private TopTrackViewHolder.TopTrackClickListener mListener;


    public TopTracksAdapter(
            Context context,
            ArrayList<TrackEntity> mTracks,
            TopTrackViewHolder.TopTrackClickListener mListener
    ) {
        this.context = context;
        this.mTracks = mTracks;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_of_track,viewGroup, false);
        return new TopTrackViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        TrackEntity trackEntity = mTracks.get(i);
        TopTrackViewHolder topTrackViewHolder = (TopTrackViewHolder) viewHolder;
        topTrackViewHolder.mTextView.setText(trackEntity.getName());
        topTrackViewHolder.mTextArtist.setText(trackEntity.getArtist().getName());
        Log.d("ogogo", "artist " + trackEntity.getImage());

        Glide
                .with(context)
                .load(trackEntity.getImage().get(2).getUrl())
                .into(topTrackViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    public void setTracks(List<TrackEntity> tracks) {
        mTracks.clear();
        mTracks.addAll(tracks);
        notifyDataSetChanged();

    }

}
