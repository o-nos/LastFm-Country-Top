package com.cv.onos.lastfmcountrytop.ui.top_artists;

import android.support.annotation.NonNull;
import android.util.Log;

import com.cv.onos.lastfmcountrytop.api.LastFmApi;
import com.cv.onos.lastfmcountrytop.api.LastFmService;
import com.cv.onos.lastfmcountrytop.base.BasePresenter;
import com.cv.onos.lastfmcountrytop.model.Artist;
import com.cv.onos.lastfmcountrytop.model.TopArtistsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by onos on 10.11.17.
 */

class MainPresenter extends BasePresenter<MainView> {

    private static final String TAG = "MainPresenter";
    private List<Artist> loadedTopArtists;
    private LastFmService lastFmService = LastFmApi.getLastFmService();

    void loadTop() {
        if (getMvpView() != null)
            getMvpView().showProgress();
        lastFmService.getTopArtistsByCountry("Ukraine").enqueue(topCallback);
    }

    void setLoadedTopArtists(List<Artist> loadedTopArtists) {
        this.loadedTopArtists = loadedTopArtists;
    }

    void onArtistItemClicked(int itemPosition) {
        if (loadedTopArtists != null) {
            Artist chosenArtist = loadedTopArtists.get(itemPosition);
            if (getMvpView() != null) {
                getMvpView().showArtistScreen(chosenArtist.getName(),
                        chosenArtist.getArtistImageUrl());
            }

        }
    }

    private Callback<TopArtistsResponse> topCallback = new Callback<TopArtistsResponse>() {
        @Override
        public void onResponse(@NonNull Call<TopArtistsResponse> call, @NonNull Response<TopArtistsResponse> response) {
            if (response.isSuccessful()) {
                if (getMvpView() != null && response.body() != null) {
                    getMvpView().hideProgress();
                    getMvpView().refreshTopList(response.body().getTopArtists().getArtist());
                }
            } else {
                int statusCode = response.code();
                // TODO handle request errors depending on status code
            }
        }

        @Override
        public void onFailure(@NonNull Call<TopArtistsResponse> call, @NonNull Throwable t) {
            Log.e(TAG, "onFailure: " + t.getMessage(), t);
            if (getMvpView() != null) {
                getMvpView().hideProgress();
                getMvpView().onTopRequestFailure(t.getMessage());
            }
        }
    };

}
