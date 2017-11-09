package com.cv.onos.lastfmcountrytop.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import lombok.Data;

/**
 * Created by onos on 09.11.17.
 */

@Data
public class TopArtists {

    private List<Artist> artist = null;

}
