package com.cv.onos.lastfmcountrytop.api;

/**
 * Created by onos on 09.11.17.
 */

public class LastFmApi {

    private static final String BASE_URL = "http://ws.audioscrobbler.com/";
    private static final String APP_API_KEY = "e81f61890b7ff8633ca024d0faa449e7";

    public static LastFmService getLastFmService() {
        return RetrofitClient.getRetrofit(BASE_URL).create(LastFmService.class);
    }


}
