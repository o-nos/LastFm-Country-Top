package com.cv.onos.lastfmcountrytop.ui.top_artists;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cv.onos.lastfmcountrytop.R;
import com.cv.onos.lastfmcountrytop.base.BaseMVPActivity;
import com.cv.onos.lastfmcountrytop.base.BasePresenter;
import com.cv.onos.lastfmcountrytop.databinding.ActivityMainBinding;
import com.cv.onos.lastfmcountrytop.model.Artist;

import java.util.List;

public class MainActivity extends BaseMVPActivity implements MainView {

    private static final String TAG = "MainActivity";

    private MainPresenter presenter = new MainPresenter();
    private ActivityMainBinding binding;

    @Override
    protected BasePresenter getBasePresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.loadButton.setOnClickListener(v -> presenter.loadTop());

    }

    @Override
    public void refreshTopList(List<Artist> topArtists) {
        binding.resultText.setText(topArtists.toString());
    }

    @Override
    public void onTopRequestFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {
    }
}
