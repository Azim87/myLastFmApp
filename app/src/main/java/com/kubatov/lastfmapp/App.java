package com.kubatov.lastfmapp;

import android.app.Application;

import com.kubatov.lastfmapp.data.artist.ArtistRepository;
import com.kubatov.lastfmapp.data.artist.IArtistRepository;
import com.kubatov.lastfmapp.data.artist.local.ArtistLocalStorage;
import com.kubatov.lastfmapp.data.artist.remote.ArtistRemoteStorage;
import com.kubatov.lastfmapp.data.tracks.ITrackRepository;
import com.kubatov.lastfmapp.data.tracks.TrackRepository;
import com.kubatov.lastfmapp.data.tracks.local.TrackLocalStorage;
import com.kubatov.lastfmapp.data.tracks.remote.TracksRemoteStorage;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {
    public static ITrackRepository trackRepository;
    public static IArtistRepository artistRepository;

    @Override
    public void onCreate() {

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name("lastfmapp.realm")
                .schemaVersion(2)
                .build();

        Realm.setDefaultConfiguration(configuration);

        super.onCreate();
        trackRepository = new TrackRepository(
                new TrackLocalStorage(),
                new TracksRemoteStorage()
        );

        artistRepository = new ArtistRepository(
                new ArtistLocalStorage(),
                new ArtistRemoteStorage()
        );
    }
}
