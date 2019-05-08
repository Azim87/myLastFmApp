package com.kubatov.lastfmapp.presentation.topArtist.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kubatov.lastfmapp.R;

public class TopArtistViewHolder extends RecyclerView.ViewHolder {
     TextView mTextArtist;
     TextView mTextTrack;
     ImageView mImageArtist;

    public TopArtistViewHolder(@NonNull View itemView,
                               final TopArtistClickListener listener) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onArtistClick(getAdapterPosition());
            }
        });

        mImageArtist = itemView.findViewById(R.id.top_artist_image_view);
        mTextArtist = itemView.findViewById(R.id.text_view_artist);
        mTextTrack = itemView.findViewById(R.id.text_view_artist_track);

    }

    public interface TopArtistClickListener{
        void onArtistClick(int position);
        void onShareClick(int position);
        void onBookmarkClick(int position);
    }
}
