package com.example.demo.processkeepalive;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LiveActivity extends AppCompatActivity {
    ScreenBroadCastListener screenBroadCastListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenBroadCastListener = new ScreenBroadCastListener(this);
        screenBroadCastListener.registerListener(new ScreenBroadCastListener.ScreenListener() {
            @Override
            public void screenOn() {
                ScreenManager.getInstance(LiveActivity.this).startActivity();
            }

            @Override
            public void screenOff() {
                ScreenManager.getInstance(LiveActivity.this).finishActivity();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        screenBroadCastListener.unRegisterListener();
    }
}
