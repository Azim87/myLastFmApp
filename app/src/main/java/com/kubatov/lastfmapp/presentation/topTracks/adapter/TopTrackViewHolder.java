package com.kubatov.lastfmapp.presentation.topTracks.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kubatov.lastfmapp.R;
import com.kubatov.lastfmapp.entities.TrackEntity;

public class TopTrackViewHolder extends RecyclerView.ViewHolder {
    TextView mTextView;
    TextView mTextArtist;
    ImageView imageView;


    public TopTrackViewHolder(
            @NonNull View itemView,
            final TopTrackClickListener listener) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTrackClick(getAdapterPosition());
            }
        });

        mTextView = itemView.findViewById(R.id.text_view_track);
        mTextArtist = itemView.findViewById(R.id.text_view_track_track);
        imageView = itemView.findViewById(R.id.top_track_image_view);
    }

    public  interface TopTrackClickListener {
        void onTrackClick(int position);
        void onShareClick(int position);
        void onBookmarkClick(int position);
    }
}
