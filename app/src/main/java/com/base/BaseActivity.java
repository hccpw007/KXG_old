package com.base;

import com.base.http.HttpForVolley;
import com.base.swipebacklayout.SwipeBackActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class BaseActivity extends SwipeBackActivity {
	private Toast toast;
	public HttpForVolley http;
	private boolean isStopHttp = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		http = new HttpForVolley(this);
	}

	/**
	 * 提示框
	 */
	public void showToast(String str) {
		try {
			if (toast != null) {
				toast.cancel();
			}
			toast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
			toast.show();
		} catch (Exception e) {
			Log.e("error", "error:" + e.getMessage());
		}
	}

	/**
	 * stop页面的时候是否执行取消网络请求
	 */
	public void setStopHttp(boolean isStopHttp) {
		this.isStopHttp = isStopHttp;
	}

	@Override
	protected void onStop() {
		super.onStop();
		if (isStopHttp) {
			BaseValue.mQueue.cancelAll(this);
		}
	}
}
