package com.cqts.kxg.center;

import android.os.Bundle;

import com.cqts.kxg.R;
import com.cqts.kxg.main.MyActivity;

public class FavoriteActivity extends MyActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        InitView();
    }

    private void InitView() {
        setMyTitle("我的收藏");
    }
}
