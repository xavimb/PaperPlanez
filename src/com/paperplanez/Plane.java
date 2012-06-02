package com.paperplanez;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.Sprite;

public class Plane {
	public static Plane instance;
	public Sprite sprite;
	Camera mCamera;
	boolean movable;
	
	public static Plane getSharedInstance()
	{
		if (instance == null)
			instance = new Plane();
        return instance;
    }
	
	public Plane()
	{
		sprite = new Sprite(0, 0, BaseActivity.getSharedInstance().mPlayerTextureRegion, BaseActivity.getSharedInstance().getVertexBufferObjectManager());
		mCamera = BaseActivity.getSharedInstance().mCamera;
		
		sprite.setPosition(mCamera.getWidth() / 2 - sprite.getWidth() / 2,
				mCamera.getHeight() - sprite.getHeight() - 10);
		movable = true;
	}
	
	public void movePlane(float accelerometerSpeedX)
	{
		int leftBorder = 0;
		int rightBorder = (int) (mCamera.getWidth() - sprite.getWidth());
		float newX;
		
		if (accelerometerSpeedX != 0)
		{
			newX = sprite.getX() - accelerometerSpeedX;
			if (newX < leftBorder)
				newX = leftBorder;
			if (newX > rightBorder)
				newX = rightBorder;
			sprite.setPosition(newX, sprite.getY());
		}
	}

}