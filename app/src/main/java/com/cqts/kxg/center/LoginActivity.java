package com.cqts.kxg.center;

import android.os.Bundle;

import com.base.BaseActivity;
import com.base.views.MyEditText;
import com.cqts.kxg.R;

public class LoginActivity extends BaseActivity {

    private MyEditText login_user_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setSwipeBackEnable(false);
        login_user_et = (MyEditText) findViewById(R.id.login_user_et);
    }
}
