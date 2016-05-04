package com.cqts.kxg.center;

import android.os.Bundle;

import com.base.BaseActivity;
import com.base.views.MyEditText;
import com.cqts.kxg.R;
import com.cqts.kxg.main.MyActivity;

public class LoginActivity extends MyActivity {

    private MyEditText login_user_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        transparencyBar(true);
        setContentView(R.layout.activity_login);
        setSwipeBackEnable(false);
        login_user_et = (MyEditText) findViewById(R.id.login_user_et);
    }
}
