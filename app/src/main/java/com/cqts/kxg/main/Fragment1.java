package com.cqts.kxg.main;

import com.base.refreshlayout.RefreshLayout;
import com.base.refreshlayout.RefreshLayout.OnRefreshListener;
import com.base.refreshlayout.RefreshLayout.ResultState;
import com.cqts.kxg.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {
	private static final String ViewGroup = null;
	private View view;
	private RefreshLayout layout;

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
		layout = (RefreshLayout) view.findViewById(R.id.layout);
		layout.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh() {
			}
		});
	}

	@Override
	public void onStop() {
		super.onStop();
		layout.setResultState(ResultState.close);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		((ViewGroup) view.getParent()).removeView(view);
	}
}
