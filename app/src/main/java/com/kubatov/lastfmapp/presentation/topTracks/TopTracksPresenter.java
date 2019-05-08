package com.kubatov.lastfmapp.presentation.topTracks;

import android.util.Log;

import com.kubatov.lastfmapp.data.tracks.ITrackRepository;
import com.kubatov.lastfmapp.entities.TrackEntity;

import java.util.List;

import core.mvp.CoreMvpPresenter;

public class TopTracksPresenter extends CoreMvpPresenter<ITopTracksContract.View>
        implements ITopTracksContract.Presenter {

    private ITrackRepository repository;

    public TopTracksPresenter(ITrackRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getTracks() {
        repository.getTracks(new ITrackRepository.TracksCallback() {
            @Override
            public void onSuccess(List<TrackEntity> tracks) {
                Log.d("ololo", "onSuccess" + tracks.size());
                if (view !=null){
                    view.showTracks(tracks);
                }
            }

            @Override
            public void onFailure(String message) {
                Log.d("ololo", "onFailure" + message);
                if (view !=null){
                    view.showMessage(message);
                }
            }
        });

    }

    @Override
    public void onTrackClick(int position) {

    }
}
