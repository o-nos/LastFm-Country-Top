package com.cv.onos.lastfmcountrytop.ui.artist_page;

import com.cv.onos.lastfmcountrytop.R;
import com.cv.onos.lastfmcountrytop.base.BaseRecyclerViewAdapter;
import com.cv.onos.lastfmcountrytop.model.Album;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by onos on 13.11.17.
 */

public class TopAlbumsAdapter extends BaseRecyclerViewAdapter {

    private List<Album> topAlbums = new ArrayList<>();

    @Override
    protected Object getObjForPosition(int position) {
        return topAlbums.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.item_album;
    }

    void setTopAlbums(List<Album> topAlbums) {
        this.topAlbums = topAlbums;
    }

    @Override
    public int getItemCount() {
        return topAlbums.size();
    }

}
