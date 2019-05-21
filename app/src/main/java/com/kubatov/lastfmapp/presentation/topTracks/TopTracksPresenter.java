package com.kubatov.lastfmapp.presentation.topTracks;

import android.util.Log;

import com.kubatov.lastfmapp.data.tracks.ITrackRepository;
import com.kubatov.lastfmapp.entities.TrackEntity;

import java.util.ArrayList;
import java.util.List;

import core.mvp.CoreMvpPresenter;

public class TopTracksPresenter extends CoreMvpPresenter<ITopTracksContract.View>
        implements ITopTracksContract.Presenter {

    private ITrackRepository repository;
    private ArrayList<TrackEntity> mCache = new ArrayList<>();
    public TopTracksPresenter(ITrackRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        getTracks();
    }

    public void setCache(List<TrackEntity> tracks){
        Log.d("ololo", "cache" + mCache.size());
        mCache.clear();
        mCache.addAll(tracks);
    }

    @Override
    public void getTracks() {
        if (view != null) {
            view.startRefresh();
        }
        repository.getTracks(new ITrackRepository.TracksCallback() {
            @Override
            public void onSuccess(List<TrackEntity> tracks) {
                setCache(tracks);
                Log.d("ololo", "onSuccess" + tracks.size());
                if (view != null) {
                    view.showTracks(tracks);
                    view.endRefresh();
                }
            }

            @Override
            public void onFailure(String message) {
                Log.d("ololo", "onFailure" + message);
                if (view != null) {
                    view.showMessage(message);
                    view.endRefresh();
                }
            }
        });
    }

    @Override
    public void onTracksClick(int position) {
        Log.d("ololo", "cache" + mCache.toString());
       if (mCache.size() > position && position >=0){
           if (view != null){
               view.openTrackDetails(mCache.get(position));
           }
       }
    }

}
