package com.cv.onos.lastfmcountrytop.ui.artist_page;

import android.support.annotation.NonNull;
import android.util.Log;

import com.cv.onos.lastfmcountrytop.api.LastFmApi;
import com.cv.onos.lastfmcountrytop.api.LastFmService;
import com.cv.onos.lastfmcountrytop.base.BasePresenter;
import com.cv.onos.lastfmcountrytop.model.TopAlbumsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by onos on 11.11.17.
 */

class ArtistPagePresenter extends BasePresenter<ArtistPageView> {

    private static final String TAG = "ArtistPagePresenter";

    private LastFmService lastFmService = LastFmApi.getLastFmService();

    void loadArtistInfoAndAlbums(String artistName) {
        if (getMvpView() != null)
            getMvpView().showProgress();
        lastFmService.getTopAlbumsByArtist(artistName).enqueue(topCallback);
    }

    private Callback<TopAlbumsResponse> topCallback = new Callback<TopAlbumsResponse>() {
        @Override
        public void onResponse(@NonNull Call<TopAlbumsResponse> call, @NonNull Response<TopAlbumsResponse> response) {
            getMvpView().hideProgress();
            if (response.isSuccessful()) {
                if (getMvpView() != null && response.body() != null) {
                    getMvpView().showArtistTopAlbums(response.body().getTopAlbums().getAlbums());
                }
            } else {
                int statusCode = response.code();
                // TODO handle request errors depending on status code
            }
        }

        @Override
        public void onFailure(@NonNull Call<TopAlbumsResponse> call, @NonNull Throwable t) {
            Log.e(TAG, "onFailure: " + t.getMessage(), t);
            if (getMvpView() != null) {
                getMvpView().hideProgress();
                getMvpView().onAlbumsRequestRequestFailure(t.getMessage());
            }
        }
    };

}
