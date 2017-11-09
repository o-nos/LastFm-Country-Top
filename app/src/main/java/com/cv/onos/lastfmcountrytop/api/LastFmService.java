package com.cv.onos.lastfmcountrytop.api;

import com.cv.onos.lastfmcountrytop.model.Top;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by onos on 09.11.17.
 */

public interface LastFmService {

    @GET("2.0?method=geo.gettopartists&api_key=e81f61890b7ff8633ca024d0faa449e7&format=json")
    Call<Top> getTopArtistsByCountry(@Query("country") String country);

}
