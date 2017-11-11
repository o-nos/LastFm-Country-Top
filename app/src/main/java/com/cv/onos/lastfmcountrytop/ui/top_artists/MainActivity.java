package com.cv.onos.lastfmcountrytop.ui.top_artists;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.cv.onos.lastfmcountrytop.R;
import com.cv.onos.lastfmcountrytop.base.BaseMVPActivity;
import com.cv.onos.lastfmcountrytop.base.BasePresenter;
import com.cv.onos.lastfmcountrytop.databinding.ActivityMainBinding;
import com.cv.onos.lastfmcountrytop.model.Artist;
import com.cv.onos.lastfmcountrytop.ui.artist_page.ArtistPageActivity;

import java.util.List;

import static com.cv.onos.lastfmcountrytop.ui.artist_page.ArtistPageActivity.ARGS_ARTIST_NAME;

public class MainActivity extends BaseMVPActivity implements MainView {

    private static final String TAG = "MainActivity";

    private MainPresenter presenter = new MainPresenter();
    private ActivityMainBinding binding;
    private TopArtistsAdapter adapter;

    @Override
    protected BasePresenter getBasePresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.loadButton.setOnClickListener(v -> presenter.loadTop());

        adapter = new TopArtistsAdapter(view ->
                presenter.onArtistItemClicked(
                binding.topRecyclerView.getChildLayoutPosition(view)));

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        binding.topRecyclerView.setLayoutManager(manager);
        binding.topRecyclerView.setAdapter(adapter);
    }

    @Override
    public void refreshTopList(List<Artist> topArtists) {
        presenter.setLoadedTopArtists(topArtists);
        adapter.setTopArtists(topArtists);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onTopRequestFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        // TODO
    }

    @Override
    public void hideProgress() {
        // TODO
    }



    @Override
    public void showArtistScreen(String artistName) {
        Intent intent = new Intent(this, ArtistPageActivity.class);
        intent.putExtra(ARGS_ARTIST_NAME, artistName);
        startActivity(intent);
    }
}
