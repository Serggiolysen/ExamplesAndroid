package com.lysenko.MVP.MVP4;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

public interface MainContract {

    interface IView extends MvpView {
        void showText(String message);
    }

    interface IPresenter extends MvpPresenter<IView> {
        void onButtonWasClicked();

        void onDestroy();
    }
}

