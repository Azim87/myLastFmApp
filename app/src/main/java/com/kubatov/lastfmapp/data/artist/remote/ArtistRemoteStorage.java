package com.kubatov.lastfmapp.data.artist.remote;

import com.kubatov.lastfmapp.data.artist.IArtistRepository;
import com.kubatov.lastfmapp.data.artist.remote.modelArtist.ArtistResponse;
import com.kubatov.lastfmapp.data.tracks.remote.TracksRemoteStorage;
import com.kubatov.lastfmapp.data.tracks.remote.modelTracks.TracksResponse;
import com.kubatov.lastfmapp.entities.ArtistEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ArtistRemoteStorage implements IArtistRemoteStorage {

    private final static String BASE_URL = "http://ws.audioscrobbler.com";
    private final static String API_KEY = "aac6723894970285d1bb062e030be8f3";

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ArtistNetworkClient client = retrofit.create(ArtistNetworkClient.class);

    @Override
    public void getArtists(final IArtistRepository.ArtistCallBack callBack) {
        Call<ArtistResponse> call = client.getArtist(
                "chart.getTopArtists",
                API_KEY,
                "json",
                1,
                100
        );

        call.enqueue(new Callback<ArtistResponse>() {
            @Override
            public void onResponse(Call<ArtistResponse> call, Response<ArtistResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callBack.onSuccess(response.body().getData().getArtist());
                    } else {
                        callBack.onFailure("Body is missing " + response.code());
                    }
                } else {
                    callBack.onFailure("Request error " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ArtistResponse> call, Throwable t) {
                callBack.onFailure(t.getMessage());
            }
        });
    }

    private interface ArtistNetworkClient {
        @GET("/2.0/")
        Call<ArtistResponse> getArtist(
                @Query("method") String method,
                @Query("api_key") String api_key,
                @Query("format") String format,
                @Query("page") int page,
                @Query("limit") int limit
        );
    }
}



