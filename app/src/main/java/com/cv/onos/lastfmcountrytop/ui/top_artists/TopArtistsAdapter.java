package com.cv.onos.lastfmcountrytop.ui.top_artists;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cv.onos.lastfmcountrytop.R;
import com.cv.onos.lastfmcountrytop.base.BaseRecyclerViewAdapter;
import com.cv.onos.lastfmcountrytop.base.BaseViewHolder;
import com.cv.onos.lastfmcountrytop.model.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by onos on 10.11.17.
 */

public class TopArtistsAdapter extends BaseRecyclerViewAdapter {

    private List<Artist> topArtists = new ArrayList<>();

    TopArtistsAdapter(View.OnClickListener onArtistClickListener) {
        setOnItemClickListener(onArtistClickListener);
    }

    @Override
    protected Object getObjForPosition(int position) {
        return topArtists.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.item_artist;
    }

    void setTopArtists(List<Artist> topArtists) {
        this.topArtists = topArtists;
    }

    @Override
    public int getItemCount() {
        return topArtists.size();
    }

}
