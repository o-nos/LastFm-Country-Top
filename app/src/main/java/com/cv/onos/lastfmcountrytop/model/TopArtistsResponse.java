package com.cv.onos.lastfmcountrytop.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by onos on 09.11.17.
 */

public class TopArtistsResponse {

    @SerializedName("topartists")
    @Expose
    private TopArtists topArtists;

    public TopArtists getTopArtists() {
        return topArtists;
    }

}
