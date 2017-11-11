package com.cv.onos.lastfmcountrytop.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by onos on 11.11.17.
 */

public class TopAlbumsResponse {

    @SerializedName("topalbums")
    @Expose
    private TopAlbums topAlbums;

    public TopAlbums getTopAlbums() {
        return topAlbums;
    }
}
