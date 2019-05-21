package com.kubatov.lastfmapp.presentation.tracks;

import com.kubatov.lastfmapp.data.tracks.ITrackRepository;
import com.kubatov.lastfmapp.entities.TrackEntity;

import core.mvp.CoreMvpPresenter;

public class TracksPresenter extends CoreMvpPresenter<ITracksContract.View>
        implements ITracksContract.Presenter {

    private ITrackRepository mRepasitory;
    private String trackId;

    public TracksPresenter(ITrackRepository mRepasitory, String trackId) {
        this.mRepasitory = mRepasitory;
        this.trackId = trackId;
    }

    @Override
    public void getTracks() {
    }

    @Override
    public void onTracksClick(int position) {
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();

        TrackEntity track = mRepasitory.getTrack(trackId);
        if (view != null && track != null){
            view.showTracks(track);
        }else {
            view.showMessage("error");
        }
    }
}
