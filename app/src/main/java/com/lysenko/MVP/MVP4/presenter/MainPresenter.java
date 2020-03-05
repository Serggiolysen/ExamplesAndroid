package com.lysenko.MVP.MVP4.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.lysenko.MVP.MVP4.MainContract;
import com.lysenko.MVP.MVP4.model.MainModel;

import java.util.Objects;

public class MainPresenter extends MvpBasePresenter<MainContract.IView>
        implements MainContract.IPresenter {

    private MainModel mainModel;

    public MainPresenter() {
        this.mainModel = new MainModel();
    }

    @Override
    public void onButtonWasClicked() {
        String message = mainModel.loadMessage();

        if (isViewAttached()) {
            Objects.requireNonNull(getView()).showText(message);
        }
    }

    @Override
    public void onDestroy() {

    }
}
