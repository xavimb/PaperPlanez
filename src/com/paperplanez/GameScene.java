package com.paperplanez;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.input.touch.TouchEvent;
import org.andengine.ui.activity.BaseGameActivity;


import android.hardware.Sensor;
import android.hardware.SensorManager;

public class GameScene extends Scene implements IOnSceneTouchListener 
{
	public Plane plane;
	Camera mCamera;
	SensorManager sensorManager;
	public float accelerometerSpeedX;
	
	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public GameScene()
	{
		setBackground(new Background(0.7f, 0.7f, 0.7f));
		mCamera = BaseActivity.getSharedInstance().mCamera;
		plane = Plane.getSharedInstance();
		plane.sprite.detachSelf();
		attachChild(plane.sprite);
		plane.sprite.setVisible(true);
		
		BaseActivity.getSharedInstance().setCurrentScene(this);
		sensorManager = (SensorManager) BaseActivity.getSharedInstance()
				.getSystemService(BaseGameActivity.SENSOR_SERVICE);
		SensorListener.getSharedInstance();
		sensorManager.registerListener(SensorListener.getSharedInstance(),
				sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_GAME);

		setOnSceneTouchListener(this);
		registerUpdateHandler(new GameLoopUpdateHandler());
	}
	
	public void movePlane() {
		System.out.println("GameScene.movePlane(): new value of acceleremoter spped x:" + accelerometerSpeedX);
		plane.movePlane(accelerometerSpeedX);
	}
	
	
}
