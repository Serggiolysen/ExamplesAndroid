package com.lysenko.MVP3;

interface IView {
    void showText(String message);
}

interface IPresenter {
    void onButtonWasClicked();
    void onDestroy();
}


