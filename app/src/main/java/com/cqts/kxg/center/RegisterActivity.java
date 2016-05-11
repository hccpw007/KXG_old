package com.cqts.kxg.center;

import android.graphics.Color;
import android.os.Bundle;

import com.cqts.kxg.R;
import com.cqts.kxg.main.MyActivity;

/**
 * 注册 填写手机号
 */
public class RegisterActivity extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTransparencyBar(true);
        InitView();
    }

    private void InitView() {
        setMyTitle("注册", Color.WHITE);
    }
}
