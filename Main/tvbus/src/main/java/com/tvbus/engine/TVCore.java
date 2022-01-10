package com.tvbus.engine;

import android.content.Context;

public class TVCore {

	private long nativeHandle;

	private static class Loader {
		static volatile TVCore INSTANCE = new TVCore();
	}

	public static TVCore getInstance() {
		return Loader.INSTANCE;
	}

	private TVCore() {
		try {
			System.loadLibrary("tvcore");
			nativeHandle = initialise();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void setTVListener(TVListener listener) {
		try {
			setListener(nativeHandle, listener);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void setPlayPort(int iPort) {
		try {
			setPlayPort(nativeHandle, iPort);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void setServPort(int iPort) {
		try {
			setServPort(nativeHandle, iPort);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void setRunningMode(int mode) {
		try {
			setRunningMode(nativeHandle, mode);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void setAuthUrl(String str) {
		try {
			setAuthUrl(nativeHandle, str);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void setMKBroker(String str) {
		try {
			setMKBroker(nativeHandle, str);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void setPassword(String str) {
		try {
			setPassword(nativeHandle, str);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void setUsername(String str) {
		try {
			setUsername(nativeHandle, str);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void start(String url) {
		try {
			start(nativeHandle, url);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		try {
			stop(nativeHandle);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	int init(Context context) {
		try {
			return init(nativeHandle, context);
		} catch (Throwable e) {
			return -1;
		}
	}

	void run() {
		try {
			run(nativeHandle);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	void quit() {
		try {
			quit(nativeHandle);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private native int init(long handle, Context context);

	private native int run(long handle);

	private native void start(long handle, String url);

	private native void stop(long handle);

	private native void quit(long handle);

	private native void setServPort(long handle, int iPort);

	private native void setPlayPort(long handle, int iPort);

	private native void setRunningMode(long handle, int mode);

	private native void setAuthUrl(long handle, String str);

	private native void setMKBroker(long handle, String str);

	private native void setPassword(long handle, String str);

	private native void setUsername(long handle, String str);

	private native void setListener(long handle, TVListener listener);

	private native long initialise();
}