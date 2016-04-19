package com.cqts.kxg.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.base.BaseFragment;
import com.base.refreshlayout.RefreshLayout;
import com.base.views.MyViewPager;
import com.cqts.kxg.R;
import com.cqts.kxg.home.adapter.HomeViewpagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends BaseFragment implements Callback, MyViewPager.OnMyPageChangeListener {
    private static final String ViewGroup = null;
    private static final int VIEWPAGER = -1;
    private Handler handler;
    private MyViewPager home_viewpager;
    private RefreshLayout layout;
    private RadioButton[] rdBtn = new RadioButton[4];
    private Timer timer;
    private TimerTask timerTask;

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
        home_viewpager = ((MyViewPager) view.findViewById(R.id.home_viewpager));
        rdBtn[0] = ((RadioButton) view.findViewById(R.id.home_rdbtn1));
        rdBtn[1] = ((RadioButton) view.findViewById(R.id.home_rdbtn2));
        rdBtn[2] = ((RadioButton) view.findViewById(R.id.home_rdbtn3));
        rdBtn[3] = ((RadioButton) view.findViewById(R.id.home_rdbtn4));


        InitViewPage();
    }

    /**
     * 广告Viewpager
     */
    private void InitViewPage() {
        home_viewpager.setOnMyPageChangeListener(this);
        home_viewpager.setAdapter(new HomeViewpagerAdapter(getActivity(), rdBtn));
        home_viewpager.setOffscreenPageLimit(3);
        home_viewpager.setCurrentItem(1, false);

        //设置循环播放
        handler = new Handler(this);
        timer = new Timer();
        timerTask = new TimerTask(){
            @Override
            public void run() {
                handler.sendEmptyMessage(VIEWPAGER);
            }
        };
        timer.schedule(timerTask,0,4000);
    }

    @Override
    public boolean handleMessage(Message msg) {
        home_viewpager.setCurrentItem(1 + home_viewpager.getCurrentItem(), true);
        return false;
    }

    /**
     * 广告Viewpager保证可以循环滑动
     */
    @Override
    public void OnMyPageSelected(int arg0) {
        if (arg0 == 0) {
            home_viewpager.setCurrentItem(3, false);
        } else if (arg0 == 4) {
            home_viewpager.setCurrentItem(1, false);
        } else {
            rdBtn[(arg0 - 1)].setChecked(true);
        }
    }

    @Override
    public void onShow() {
        super.onShow();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
