package com.base;

import android.app.Application;
import android.util.DisplayMetrics;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class BaseValue {
	
	public final static boolean isDebug = true;// 调试开关
	public static int screenwidth;// 屏幕宽度
	public static int screenHeight;// 屏幕高度
	public static float density;// 屏幕密度
	public static int densityDPI;// 屏幕密度
	public static Gson gson;
	public static RequestQueue mQueue;
	
	
	public static void setInit(Application application) {
		DisplayMetrics displayMetrics = new DisplayMetrics();
		displayMetrics = application.getResources().getDisplayMetrics();
		screenHeight = displayMetrics.heightPixels;
		screenwidth = displayMetrics.widthPixels;
		density = displayMetrics.density;
		densityDPI = displayMetrics.densityDpi;
		gson = new Gson();
		mQueue = Volley.newRequestQueue(application);
		
	}
	
	/**
	 * dp转px
	 */
	public static int dp2px(float dipValue) {
		return (int) (dipValue * density + 0.5f);
	}
}
