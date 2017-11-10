package com.cv.onos.lastfmcountrytop.ui.top_artists;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.cv.onos.lastfmcountrytop.BR;


/**
 * Created by onos on 10.11.17.
 */

class TopArtistViewHolder extends RecyclerView.ViewHolder {

    private final ViewDataBinding binding;

    TopArtistViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(Object artist) {
        binding.setVariable(BR.artist, artist);
        binding.executePendingBindings();
    }

}
