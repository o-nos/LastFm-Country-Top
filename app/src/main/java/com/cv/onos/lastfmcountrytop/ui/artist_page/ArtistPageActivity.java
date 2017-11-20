package com.cv.onos.lastfmcountrytop.ui.artist_page;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cv.onos.lastfmcountrytop.R;
import com.cv.onos.lastfmcountrytop.base.BaseMVPActivity;
import com.cv.onos.lastfmcountrytop.base.BasePresenter;
import com.cv.onos.lastfmcountrytop.databinding.ActivityArtistPageBinding;
import com.cv.onos.lastfmcountrytop.model.Album;

import java.util.List;

public class ArtistPageActivity extends BaseMVPActivity implements ArtistPageView {

    public static final String ARGS_ARTIST_NAME = "args_artist_name";
    public static final String ARGS_ARTIST_PHOTO_URL = "args_artist_photo_url";
    private static final String TAG = "ArtistPageActivity";

    private ArtistPagePresenter presenter = new ArtistPagePresenter();
    private ActivityArtistPageBinding binding;
    private TopAlbumsAdapter adapter;

    @Override
    protected BasePresenter getBasePresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist_page);

        String artistName = getIntent().getStringExtra(ARGS_ARTIST_NAME);
        presenter.loadArtistInfoAndAlbums(artistName);
        loadArtistPhoto(getIntent().getStringExtra(ARGS_ARTIST_PHOTO_URL));

        setSupportActionBar(binding.toolbar);
        binding.collapsingToolbarLayout.setTitle(artistName);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        adapter = new TopAlbumsAdapter();

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        binding.topAlbumsRecyclerView.setLayoutManager(manager);
        binding.topAlbumsRecyclerView.setAdapter(adapter);

    }

    private void loadArtistPhoto(String stringExtra) {
        if (stringExtra != null) {
            Glide.with(this)
                    .load(stringExtra)
                    .into(binding.artistImageView);
        }
    }


    @Override
    public void onAlbumsRequestRequestFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showArtistTopAlbums(List<Album> albums) {
        adapter.setTopAlbums(albums);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
