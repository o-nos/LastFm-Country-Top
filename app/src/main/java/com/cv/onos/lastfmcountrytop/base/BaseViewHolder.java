package com.cv.onos.lastfmcountrytop.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.cv.onos.lastfmcountrytop.BR;

/**
 * Created by onos on 13.11.17.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private final ViewDataBinding binding;

    BaseViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Object obj) {
        binding.setVariable(BR.obj, obj);
        binding.executePendingBindings();
    }

}
