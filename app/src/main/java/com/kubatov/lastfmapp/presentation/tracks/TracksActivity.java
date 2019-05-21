package com.kubatov.lastfmapp.presentation.tracks;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.kubatov.lastfmapp.App;
import com.kubatov.lastfmapp.R;
import com.kubatov.lastfmapp.entities.TrackEntity;

import core.mvp.CoreMvpActivity;

public class TracksActivity extends CoreMvpActivity<ITracksContract.Presenter>
        implements ITracksContract.View {
    private static final String EXTRA_ID = "track_id";

   private TextView trekview;

    //region Static
    public static void start(Activity activity, String trackId){
        Intent intent = new Intent(activity, TracksActivity.class);
        intent.putExtra(EXTRA_ID, trackId);
        activity.startActivity(intent);
    }

    private static String getTrackId(Intent intent){
        return intent.getStringExtra(EXTRA_ID);
    }
//endregion
    @Override
    protected int getLayoutId() {
        return R.layout.activity_tracks;
    }

    @Nullable
    @Override
    protected void initView() {
        trekview = findViewById(R.id.trek_view);
    }

    @Nullable
    @Override
    protected TracksPresenter providePresenter() {
        return new TracksPresenter(
                App.trackRepository,
                getTrackId(getIntent())
        );
    }

    @Override
    public void showTracks(TrackEntity trackEntity) {
        trekview.setText(trackEntity.getArtist().getName());
    }

    @Override
    public void openTrackDetails(TrackEntity tracks) {

    }
}
