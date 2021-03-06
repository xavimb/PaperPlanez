package com.paperplanez;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.graphics.Typeface;

public class BaseActivity extends SimpleBaseGameActivity {
	// Singleton for the game scenario
	public Scene mCurrentScene;
	public static BaseActivity instance;
	static final int CAMERA_WIDTH = 480;
	static final int CAMERA_HEIGHT = 800;
	public static final float MAX_CHARGE_DISTANCE = 80;
	public Camera mCamera;
	public Font mFont;
	
    public BitmapTextureAtlas mBitmapTextureAtlas;
    public TextureRegion mPlayerTextureRegion;

	public EngineOptions onCreateEngineOptions() {
		instance = this;
		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new EngineOptions(true, ScreenOrientation.PORTRAIT_SENSOR,
				new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
	}

	protected void onCreateResources() {
		mFont = FontFactory.create(this.getFontManager(),
				this.getTextureManager(), 256, 256,
				Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 32);
		mFont.load();
	    mBitmapTextureAtlas = new BitmapTextureAtlas(this.getTextureManager(), 200, 120);
	    mPlayerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "airplaneStill.png", 0, 0);
	    mBitmapTextureAtlas.load();
	}

	protected Scene onCreateScene() {
		mEngine.registerUpdateHandler(new FPSLogger());
		mCurrentScene = new SplashScene();
		return mCurrentScene;
	}

	public static BaseActivity getSharedInstance() {
		return instance;
	}

	public void setCurrentScene(Scene scene) {
		mCurrentScene = scene;
		getEngine().setScene(mCurrentScene);
	}
}
