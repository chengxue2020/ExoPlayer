package com.forcetech.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.forcetech.android.ForceTV;

public class P5PService extends Service {

	private ForceTV forceTV;

	@Override
	public IBinder onBind(Intent intent) {
		forceTV = new ForceTV();
		forceTV.start("p5p", 6001);
		return null;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		if (forceTV != null) forceTV.stop();
		return super.onUnbind(intent);
	}
}
