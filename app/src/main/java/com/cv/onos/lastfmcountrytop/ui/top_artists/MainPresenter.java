package com.cv.onos.lastfmcountrytop.ui.top_artists;

import android.support.annotation.NonNull;
import android.util.Log;

import com.cv.onos.lastfmcountrytop.api.LastFmApi;
import com.cv.onos.lastfmcountrytop.api.LastFmService;
import com.cv.onos.lastfmcountrytop.base.BasePresenter;
import com.cv.onos.lastfmcountrytop.model.Top;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by onos on 10.11.17.
 */

class MainPresenter extends BasePresenter<MainView> {

    private static final String TAG = "MainPresenter";

    private LastFmService lastFmService = LastFmApi.getLastFmService();
    private Callback<Top> topCallback = new Callback<Top>() {
        @Override
        public void onResponse(@NonNull Call<Top> call, @NonNull Response<Top> response) {
            getMvpView().hideProgress();
            if (response.isSuccessful()) {
                if (getMvpView() != null && response.body() != null) {
                    getMvpView().refreshTopList(response.body().getTopArtists().getArtist());
                }
            } else {
                int statusCode = response.code();
                // TODO handle request errors depending on status code
            }
        }

        @Override
        public void onFailure(@NonNull Call<Top> call, @NonNull Throwable t) {
            Log.e(TAG, "onFailure: " + t.getMessage(), t);
            if (getMvpView() != null) {
                getMvpView().hideProgress();
                getMvpView().onTopRequestFailure(t.getMessage());
            }
        }
    };


    void loadTop() {
        getMvpView().showProgress();
        lastFmService.getTopArtistsByCountry("Ukraine").enqueue(topCallback);
    }


}
