package com.lysenko.MVP3;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.lysenko.R;


public class MainActivity extends AppCompatActivity implements IView {

    private IPresenter mPresenter; private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mvp);
        textView = findViewById(R.id.text_view);
        Button mButton = findViewById(R.id.button);

        mPresenter = new MainPresenter(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onButtonWasClicked();
            }
        });
    }

    @Override
    public void showText(String message) {
        textView.setText(message);
    }
}
