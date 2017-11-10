package com.cv.onos.lastfmcountrytop.base;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by onos on 10.11.17.
 */

public class BasePresenter<T extends BaseView> {

    private static final Handler handler = new Handler(Looper.getMainLooper());
    private T mvpView;

    public void attachView(T mvpView) {
        this.mvpView = mvpView;
    }

    public void detachView() {
        this.mvpView = null;
    }

    public T getMvpView() {
        return mvpView;
    }

    public void onResume() {
    }

    public void onPause() {
    }

    protected void showProgress(int progressId) {
        if (getMvpView() != null) {
            getMvpView().showProgress();
        }
    }

    protected void hideProgress(int progressId) {
        if (getMvpView() != null) {
            getMvpView().hideProgress();
        }
    }


    boolean isViewAttached() {
        return mvpView != null;
    }

    protected void runOnUIThread(Runnable runnable) {
        if (getMvpView() != null) {
            handler.post(runnable);
        }
    }

}
