package com.cv.onos.lastfmcountrytop.ui.artist_page;

import com.cv.onos.lastfmcountrytop.base.BaseView;
import com.cv.onos.lastfmcountrytop.model.Album;

import java.util.List;

/**
 * Created by onos on 11.11.17.
 */

interface ArtistPageView extends BaseView {

    void onAlbumsRequestRequestFailure(String message);

    void showArtistTopAlbums(List<Album> albums);

}
