package com.paperplanez;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;



public class Input implements SensorEventListener  {

	static Input instance;
	GameScene scene;
	public float pos;
	
	public static Input getSharedInstance() {
		if (instance == null)
			instance = new Input();
		return instance;
	}

	private Input() {
		instance = this;
		scene = (GameScene) BaseActivity.getSharedInstance().mCurrentScene;
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {

	}

	
	public void onSensorChanged(SensorEvent event) {
		synchronized (this) {
			switch (event.sensor.getType()) {
			case Sensor.TYPE_ACCELEROMETER:
				// Log.v("Jimvaders",
				// "SensorListener onSensorChanged() accelerometerSpeedX = "+event.values[1]);
				pos = event.values[1];
				break;
			default:
				break;
			}
		}

	}
}
