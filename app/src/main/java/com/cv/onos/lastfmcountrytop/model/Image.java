package com.cv.onos.lastfmcountrytop.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by onos on 09.11.17.
 */

public class Image {

    @SerializedName("#text")
    @Expose
    private String url;
    @SerializedName("size")
    @Expose
    private String size;

    public String getUrl() {
        return url;
    }

    public String getSize() {
        return size;
    }

}
