package com.paperplanez;

import org.andengine.engine.handler.IUpdateHandler;

public class GameLoopUpdateHandler implements IUpdateHandler{

	public void onUpdate(float pSecondsElapsed) {
		((GameScene)BaseActivity.getSharedInstance().mCurrentScene).movePlane();
		//((GameScene)BaseActivity.getSharedInstance().mCurrentScene).cleaner();
		
	}

	
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
