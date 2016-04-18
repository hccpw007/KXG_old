package com.cqts.kxg.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.base.BaseFragment;
import com.base.refreshlayout.RefreshLayout;
import com.base.views.MyViewPager;
import com.cqts.kxg.R;
import com.cqts.kxg.home.adapter.HomeViewpagerAdapter;

public class Fragment1 extends BaseFragment implements Callback, MyViewPager.OnMyPageChangeListener {
    private static final String ViewGroup = null;
    private static final int VIEWPAGER = -1;
    private Handler handler;
    private MyViewPager home_viewpager;
    private boolean isStart = true;
    private RefreshLayout layout;
    private RadioButton[] rdBtn = new RadioButton[4];
    private Thread thread = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (null == view) {
            view = inflater.inflate(R.layout.activity_main, null);
            InitView();
        }
        return view;
    }

    private void InitView() {
        this.home_viewpager = ((MyViewPager) this.view.findViewById(R.id.home_viewpager));
        this.rdBtn[0] = ((RadioButton) this.view.findViewById(R.id.home_rdbtn1));
        this.rdBtn[1] = ((RadioButton) this.view.findViewById(R.id.home_rdbtn2));
        this.rdBtn[2] = ((RadioButton) this.view.findViewById(R.id.home_rdbtn3));
        this.rdBtn[3] = ((RadioButton) this.view.findViewById(R.id.home_rdbtn4));
        this.handler = new Handler(this);
        InitViewPage();
    }

    private void InitViewPage() {
        this.home_viewpager.setOnMyPageChangeListener(this);
        this.home_viewpager.setAdapter(new HomeViewpagerAdapter(getActivity(), this.rdBtn));
        this.home_viewpager.setOffscreenPageLimit(3);
        this.home_viewpager.setCurrentItem(1, false);
        this.thread = new Thread(new Runnable() {
            public void run() {
                while (isStart) {
                    try {
                        new Thread();
                        Thread.sleep(4000L);
                    } catch (InterruptedException localInterruptedException) {
                    }
                    handler.sendEmptyMessage(VIEWPAGER);
                }
            }
        }) {
        };
        this.thread.start();
    }

    @Override
    public boolean handleMessage(Message msg) {
        this.home_viewpager.setCurrentItem(1 + this.home_viewpager.getCurrentItem(), false);
        return false;
    }

    @Override
    public void OnMyPageSelected(int arg0) {
        if (arg0 == 0) {
            this.home_viewpager.setCurrentItem(3, false);
        } else if (arg0 == 4) {
            this.home_viewpager.setCurrentItem(1, false);
        } else {
            this.rdBtn[(arg0 - 1)].setChecked(true);
        }
    }

    @Override
    public void onShow() {
        super.onShow();
        System.out.println("onShow");
        this.isStart = true;
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("onStop");
        this.isStart = false;
    }
}
