package com.lysenko.MVP.MVP3;

public class MainPresenter implements IPresenter {

    private IView iView;
    private MainModel mainModel;

    MainPresenter(IView iView) {
        this.iView = iView;
        this.mainModel = new MainModel();
    }

    @Override
    public void onButtonWasClicked() {
        String message = mainModel.loadMessage();
        iView.showText(message);
    }

    @Override
    public void onDestroy() {

    }
}
