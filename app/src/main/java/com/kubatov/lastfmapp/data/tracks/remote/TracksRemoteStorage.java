package com.kubatov.lastfmapp.data.tracks.remote;

import android.util.Log;

import com.kubatov.lastfmapp.data.tracks.ITrackRepository;
import com.kubatov.lastfmapp.data.tracks.remote.modelTracks.TracksResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class TracksRemoteStorage implements ITrackRemoteStorage {

    private final static String BASE_URL = "http://ws.audioscrobbler.com";
    private final static String API_KEY = "aac6723894970285d1bb062e030be8f3";

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static TrackNetworkClient client = retrofit.create(TrackNetworkClient.class);

    @Override
    public void getTracks(final ITrackRepository.TracksCallback callback) {
        Call<TracksResponse> call = client.getTracks(
                "chart.getTopTracks",
                API_KEY,
                "json",
                1,
                100
        );
        call.enqueue(new Callback<TracksResponse>() {
            @Override
            public void onResponse(Call<TracksResponse> call, Response<TracksResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d("ololo", "onResponse");
                        callback.onSuccess(response.body().getTracks().getData());
                    } else {
                        callback.onFailure("The body is empty: " + response.code());
                    }
                } else {
                    callback.onFailure("Request error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<TracksResponse> call, Throwable t) {
                callback.onFailure("Top tracks failure: " + t.getMessage());
            }
        });
    }

    private interface TrackNetworkClient {
        @GET("/2.0/")
        Call<TracksResponse> getTracks(
                @Query("method") String method,
                @Query("api_key") String api_key,
                @Query("format") String format,
                @Query("page") int page,
                @Query("limit") int limit
        );
    }
}
