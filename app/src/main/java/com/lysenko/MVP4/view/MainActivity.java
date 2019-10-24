package com.lysenko.MVP4.view;

import com.lysenko.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.lysenko.MVP4.MainContract;
import org.jetbrains.annotations.NotNull;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.lysenko.MVP4.presenter.MainPresenter;

public class MainActivity extends MvpActivity<MainContract.IView, MainContract.IPresenter>
        implements MainContract.IView {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mvp);
        textView = findViewById(R.id.text_view);
        Button mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onButtonWasClicked();
            }
        });
    }

    @NotNull
    @Override
    public MainContract.IPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void showText(String message) {
        textView.setText(message);
    }
}
