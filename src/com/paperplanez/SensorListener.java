package com.paperplanez;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

public class SensorListener implements SensorEventListener {

	static SensorListener instance;
	GameScene scene;

	public static SensorListener getSharedInstance() {
		if (instance == null)
			instance = new SensorListener();
		return instance;
	}

	private SensorListener() {
		instance = this;
		scene = (GameScene) BaseActivity.getSharedInstance().mCurrentScene;
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		Log.d("TEST", "SensorListener.onSensorChanged()");
		synchronized (this) {
			switch (event.sensor.getType()) {
			case Sensor.TYPE_ACCELEROMETER:
				// Log.v("Jimvaders",
				// "SensorListener onSensorChanged() accelerometerSpeedX = "+event.values[1]);
				scene.accelerometerSpeedX = event.values[0];
				System.out.println(scene.accelerometerSpeedX);
				break;
			default:
				break;
			}
		}

	}

}
