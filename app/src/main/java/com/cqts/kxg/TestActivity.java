package com.cqts.kxg;

import android.app.Activity;
import android.os.Bundle;

import com.cqts.kxg.main.MyActivity;

public class TestActivity extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
}
