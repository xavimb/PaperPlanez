package com.paperplanez;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.primitive.Rectangle;



public class Plane {
	public static Plane instance;
	public Rectangle sprite;
	Camera mCamera;

	public static Plane getSharedInstance()
	{
		if (instance == null)
			instance = new Plane();
        return instance;
    }
	
	public Plane()
	{
		sprite = new Rectangle(0, 0, 20, 50, BaseActivity.getSharedInstance().getVertexBufferObjectManager());
		Camera mCamera = BaseActivity.getSharedInstance().mCamera;
		sprite.setPosition(mCamera.getWidth() / 2 - sprite.getWidth() / 2,
				mCamera.getHeight() - sprite.getHeight() - 10);
	}
}