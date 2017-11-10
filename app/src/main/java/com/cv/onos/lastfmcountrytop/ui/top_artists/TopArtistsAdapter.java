package com.cv.onos.lastfmcountrytop.ui.top_artists;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.cv.onos.lastfmcountrytop.R;
import com.cv.onos.lastfmcountrytop.model.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by onos on 10.11.17.
 */

public class TopArtistsAdapter extends RecyclerView.Adapter<TopArtistViewHolder> {

    private List<Artist> topArtists = new ArrayList<>();

    @Override
    public TopArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil
                .inflate(layoutInflater, R.layout.item_artist, parent, false);

        return new TopArtistViewHolder(binding);
    }

    void setTopArtists(List<Artist> topArtists) {
        this.topArtists = topArtists;
    }

    @Override
    public void onBindViewHolder(TopArtistViewHolder holder, int position) {
        final Artist temperatureData = topArtists.get(position);
        holder.bind(temperatureData);
    }

    @Override
    public int getItemCount() {
        return topArtists.size();
    }
}
