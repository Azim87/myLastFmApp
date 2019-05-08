package com.kubatov.lastfmapp.presentation.topTracks;

import com.kubatov.lastfmapp.entities.TrackEntity;
import java.util.List;
import core.mvp.ICoreMvpContract;

public interface ITopTracksContract {

    interface View extends ICoreMvpContract.View<Presenter> {

        void showTracks(List<TrackEntity> tracks);
        void openTrackDetails(TrackEntity track);
        void showMessage(String message);
    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {

        void getTracks();
        void onTrackClick(int position);

    }
}
