package com.cv.onos.lastfmcountrytop.api;

import com.cv.onos.lastfmcountrytop.model.TopAlbumsResponse;
import com.cv.onos.lastfmcountrytop.model.TopArtistsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by onos on 09.11.17.
 */

public interface LastFmService {

    @GET("2.0?method=geo.gettopartists&api_key=e81f61890b7ff8633ca024d0faa449e7&format=json")
    Call<TopArtistsResponse> getTopArtistsByCountry(@Query("country") String country);

    @GET("2.0?method=artist.gettopalbums&api_key=e81f61890b7ff8633ca024d0faa449e7&format=json")
    Call<TopAlbumsResponse> getTopAlbumsByArtist(@Query("artist") String artist);
}
