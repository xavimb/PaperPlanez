package com.paperplanez;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.Bundle;



public class Input extends Activity implements SensorEventListener  {

	private SensorManager sensorManager;
	public float pos;
	 
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
				
		sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
		// add listener. The listener will be HelloAndroid (this) class
		sensorManager.registerListener(this,
				sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),
				SensorManager.SENSOR_DELAY_GAME);
	
	}
	
	public void onSensorChanged(SensorEvent event){

		// check sensor type
		if(event.sensor.getType()==Sensor.TYPE_GYROSCOPE){

			// assign directions
			//float x=event.values[0];
			pos = event.values[1];
			//float z=event.values[2];

			
		}
	
	
	
	}

	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
}
