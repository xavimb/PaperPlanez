package com.paperplanez;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.input.touch.TouchEvent;

import android.hardware.SensorManager;

public class GameScene extends Scene implements IOnSceneTouchListener 
{
	public Plane plane;
	Camera mCamera;
	SensorManager sensorManager;
	public float accelerometerSpeedX;

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
	}
	
}
