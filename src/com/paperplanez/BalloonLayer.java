package com.paperplanez;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import org.andengine.entity.Entity;
import org.andengine.entity.modifier.LoopEntityModifier;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.modifier.MoveXModifier;
import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;

import android.util.Log;


public class BalloonLayer extends Entity {

	private LinkedList<Balloon> balloons;
	public static BalloonLayer instance;
	public int balloonCount;

	public static BalloonLayer getSharedInstance() {
		return instance;
	}

	public static Iterator<Balloon> getIterator() {
		return instance.balloons.iterator();
	}

	public void purge() {

		/*detachChildren();
		for (Balloon e : balloons) {
			BalloonPool.sharedBalloonPool().recyclePoolItem(e);
		}
		balloons.clear();*/
	}

	public BalloonLayer(int x) {
		balloons = new LinkedList<Balloon>();
		instance = this;
		balloonCount = x;
	}

	public void restart() {
		Log.v("jimvaders", "EnemyLayer restarted");
		balloons.clear();
		clearEntityModifiers();
		clearUpdateHandlers();

		for (int i = 0; i < balloonCount; i++) {
			Balloon e = BalloonPool.sharedBalloonPool().obtainPoolItem();
			float finalPosX = (i % 6) * 4 * e.sprite.getWidth();
			float finalPosY = ((int) (i / 6)) * e.sprite.getHeight() * 2;

			Random r = new Random();
			e.sprite.setPosition(r.nextInt(2) == 0 ? -e.sprite.getWidth() * 3
					: BaseActivity.CAMERA_WIDTH + e.sprite.getWidth() * 3,
					(r.nextInt(5) + 1) * e.sprite.getHeight());
			e.sprite.setVisible(true);

			attachChild(e.sprite);
			e.sprite.registerEntityModifier(new MoveModifier(2,
					e.sprite.getX(), finalPosX, e.sprite.getY(), finalPosY));

			balloons.add(e);
		}
		setVisible(true);
		setPosition(50, 30);

		MoveXModifier movRight = new MoveXModifier(1, 50, 120);
		MoveXModifier movLeft = new MoveXModifier(1, 120, 50);
		MoveYModifier moveDown = new MoveYModifier(1, 30, 100);
		MoveYModifier moveUp = new MoveYModifier(1, 100, 30);

		registerEntityModifier(new LoopEntityModifier(
				new SequenceEntityModifier(movRight, moveDown, movLeft, moveUp)));

	}

	public static void purgeAndRestart() {
		instance.purge();
		instance.restart();
	}

	@Override
	public void onDetached() {
		purge();
		clearUpdateHandlers();
		super.onDetached();
	}

}