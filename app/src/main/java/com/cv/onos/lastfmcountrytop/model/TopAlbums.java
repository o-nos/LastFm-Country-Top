package com.cv.onos.lastfmcountrytop.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by onos on 11.11.17.
 */

public class TopAlbums {

    @SerializedName("album")
    @Expose
    private List<Album> album = null;
    @SerializedName("@attr")
    @Expose
    private Attr attr;

    public List<Album> getAlbums() {
        return album;
    }

    public void setAlbums(List<Album> album) {
        this.album = album;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }
}