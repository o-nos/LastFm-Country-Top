package com.cv.onos.lastfmcountrytop.model;

import java.util.List;

import lombok.Data;

/**
 * Created by onos on 09.11.17.
 */

@Data
public class Artist {

    public String name;
    public String listeners;
    public String mbid;
    public String url;
    public String streamable;
    public List<Image> images;

}
