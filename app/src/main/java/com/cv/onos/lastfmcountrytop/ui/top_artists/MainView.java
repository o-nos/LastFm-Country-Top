package com.cv.onos.lastfmcountrytop.ui.top_artists;

import com.cv.onos.lastfmcountrytop.base.BaseView;
import com.cv.onos.lastfmcountrytop.model.Artist;

import java.util.List;

/**
 * Created by onos on 10.11.17.
 */

interface MainView extends BaseView {

    void refreshTopList(List<Artist> topArtists);

    void onTopRequestFailure(String message);

    void showArtistScreen(String artistName, String artistPhotoUrl);
}
