package com.keenhi.mid.core.hiddenapi;

import android.app.StatusBarManager;
import android.content.Context;
import android.hardware.input.InputManager;
import android.util.Log;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewRootImpl;

public class Hiddenapi {
	
	private static final String TAG = Hiddenapi.class.getSimpleName();

	public Hiddenapi() {
		
	}
	
	public static void enqueueKeyEvent(View v,KeyEvent event) {
		ViewRootImpl vri =v.getViewRootImpl();
		vri.dispatchKey(event);
	}
	
	public static void injectInputEvent(InputEvent ie, int mode){
		InputManager.getInstance().injectInputEvent(ie, mode);
	}
	
	public static void injectInputEventAsy(InputEvent ie){
		InputManager.getInstance().injectInputEvent(ie, InputManager.INJECT_INPUT_EVENT_MODE_WAIT_FOR_FINISH);
	}
	
	public static Object initStatusBar(Context context){
		StatusBarManager sbm =(StatusBarManager) context.getSystemService(Context.STATUS_BAR_SERVICE);
		return sbm;
	}
	
	public static void disableStatusBarPredefine(Object sbm){
		if(sbm instanceof StatusBarManager){
			Log.d(TAG,"disable the status bar");
			((StatusBarManager)sbm).disable(StatusBarManager.DISABLE_BACK|StatusBarManager.DISABLE_HOME|StatusBarManager.DISABLE_EXPAND|StatusBarManager.DISABLE_RECENT);
		}
	}
	
	public static void enableStatusBarPredefine(Object sbm){
		if(sbm instanceof StatusBarManager){
			Log.d(TAG,"enable the status bar");
			((StatusBarManager)sbm).disable(StatusBarManager.DISABLE_NONE);
		}
	}

}
