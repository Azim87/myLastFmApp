package com.kubatov.lastfmapp.data.tracks.local;

import com.kubatov.lastfmapp.data.tracks.ITrackRepository;
import com.kubatov.lastfmapp.entities.ArtistEntity;
import com.kubatov.lastfmapp.entities.ArtistImage;
import com.kubatov.lastfmapp.entities.TrackEntity;
import com.kubatov.lastfmapp.entities.TrackImage;
import com.kubatov.lastfmapp.presentation.tracks.TracksActivity;

import java.util.ArrayList;
import java.util.List;

import core.CoreRealm.CoreRealmDataSource;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class TrackLocalStorage extends CoreRealmDataSource
        implements ITrackLocalStorage {

    //region Mapper
    private RTrack rTrackToTracks(TrackEntity track) {

        RShortArtist artist = new RShortArtist(track.getArtist().getName(),
                track.getArtist().getUrl());
        RealmList<RImage> image = new RealmList<>();

        for (ArtistImage images : track.getImage()) {
            image.add(new RImage(images.getUrl(), images.getSize()));
        }

        return new RTrack(
                track.getName(),
                track.getUrl(),
                track.getPlaycount(),
                track.getListeners(),
                track.getUniqueId(),
                image,
                artist
        );

    }

    private TrackEntity tracksToRTrack(RTrack track) {

        ArtistEntity artist = new ArtistEntity("", track.getArtist().getName(), track.getArtist().getUrl());

        ArrayList<ArtistImage> images = new ArrayList<>();

        for (RImage image : track.getImages()) {
            images.add(new ArtistImage(image.getUrl(), image.getSize()));
        }

        return new TrackEntity(
                track.getName(),
                artist,
                track.getUrl(),
                track.getPlaycount(),
                track.getListeners(),
                images
        );
    }

    private List<RTrack> rTrackToTrack(List<TrackEntity> trackEntities) {
        ArrayList<RTrack> result = new ArrayList<>();
        for (TrackEntity trackEntity : trackEntities) {
            result.add(rTrackToTracks(trackEntity));
        }
        return result;
    }

    private List<TrackEntity> TrackToRTrack(List<RTrack> rTracks) {
        ArrayList<TrackEntity> result = new ArrayList<>();
        for (RTrack track : rTracks) {
            result.add(tracksToRTrack(track));
        }
        return result;
    }

    //endregion

    @Override
    public void getTracks(ITrackRepository.TracksCallback callback) {
        Realm realm = null;

        try {
            realm = getRealmInstance();
            RealmResults<RTrack> results = realm.where(RTrack.class).findAll();

            callback.onSuccess(
                    TrackToRTrack(realm.copyFromRealm(results)));

        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    @Override
    public void getArtistTopTracks(String artistName, ITrackRepository.TracksCallback artistCallback) {

    }

    @Override
    public void setTracks(List<TrackEntity> tracks) {
        List<RTrack> rTracks = rTrackToTrack(tracks);
        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    realm.copyToRealmOrUpdate(rTracks);
                } catch (Exception e) {
                    e.getMessage();
                } finally {
                    realm.close();
                }
            }
        });
    }

    @Override
    public TrackEntity getTrack() {
        return null;
    }
}
