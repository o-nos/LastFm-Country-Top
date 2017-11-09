package com.cv.onos.lastfmcountrytop;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cv.onos.lastfmcountrytop.api.LastFmApi;
import com.cv.onos.lastfmcountrytop.api.LastFmService;
import com.cv.onos.lastfmcountrytop.databinding.ActivityMainBinding;
import com.cv.onos.lastfmcountrytop.model.Top;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;
    private LastFmService lastFmService = LastFmApi.getLastFmService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.loadButton.setOnClickListener(v -> loadTop());

    }

    private void loadTop() {
        lastFmService.getTopArtistsByCountry("Ukraine").enqueue(new Callback<Top>() {
            @Override
            public void onResponse(Call<Top> call, Response<Top> response) {
                if (response.isSuccessful()) {
                    Log.d("MainActivity", "posts loaded from API");

                    updateUI(response.body());

                } else {
                    int statusCode = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<Top> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage(), t);
            }
        });

    }

    private void updateUI(Top topArtists) {
        binding.resultText.setText(topArtists.toString());
    }


}
