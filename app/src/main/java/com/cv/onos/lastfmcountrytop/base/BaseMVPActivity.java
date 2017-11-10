package com.cv.onos.lastfmcountrytop.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by onos on 10.11.17.
 */

public abstract class BaseMVPActivity extends AppCompatActivity implements BaseView {

    protected abstract BasePresenter getBasePresenter();

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getBasePresenter().attachView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        getBasePresenter().onResume();
    }

    @Override
    public void onPause() {
        getBasePresenter().onPause();
        super.onPause();
    }

    @Override
    public void onStop() {
        getBasePresenter().detachView();
        super.onStop();
    }


}
