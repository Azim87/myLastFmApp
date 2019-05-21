package com.kubatov.lastfmapp.presentation.tracks;


import com.kubatov.lastfmapp.entities.TrackEntity;

import core.mvp.ICoreMvpContract;

public interface ITracksContract {

    interface View extends ICoreMvpContract.View<Presenter> {

        void showTracks(TrackEntity trackEntity);

        void openTrackDetails(TrackEntity tracks);
    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {

        void getTracks();

        void onTracksClick(int position);
    }
}
