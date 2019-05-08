package com.kubatov.lastfmapp.presentation.topArtist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kubatov.lastfmapp.R;
import com.kubatov.lastfmapp.entities.ArtistEntity;

import java.util.ArrayList;
import java.util.List;

public class TopArtistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ArtistEntity> mArtist;
    private Context context;
    private TopArtistViewHolder.TopArtistClickListener mListener;
    private TopArtistViewHolder topArtistViewHolder;

    public TopArtistAdapter(
            Context context,
            List<ArtistEntity> mArtist,
            TopArtistViewHolder.TopArtistClickListener listener
    ) {
        this.context = context;
        this.mArtist = mArtist;
        this.mListener = listener;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_of_artist, viewGroup, false);
        return new TopArtistViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ArtistEntity artist = mArtist.get(i);
        topArtistViewHolder = (TopArtistViewHolder) viewHolder;
        topArtistViewHolder.mTextArtist.setText(artist.getName());

        Glide
                .with(context)
                .load(artist.getImages().get(2).getUrl())
                .into(topArtistViewHolder.mImageArtist);
    }

    @Override
    public int getItemCount() {
        return mArtist.size();
    }

    public void setArtists(List<ArtistEntity> artist) {
        mArtist.clear();
        mArtist.addAll(artist);
        notifyDataSetChanged();
    }
}
