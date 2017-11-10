package com.cv.onos.lastfmcountrytop.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by onos on 09.11.17.
 */

public class Top {

    @SerializedName("topartists")
    @Expose
    private TopArtists topArtists;

    public TopArtists getTopArtists() {
        return topArtists;
    }

    public void setTopArtists(TopArtists topartists) {
        this.topArtists = topartists;
    }
}
