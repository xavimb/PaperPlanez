package com.paperplanez;

import org.andengine.util.adt.pool.GenericPool;

public class BalloonPool extends GenericPool<Balloon> {

	public static BalloonPool instance;

	public static BalloonPool sharedBalloonPool() {

		if (instance == null)
			instance = new BalloonPool();
		return instance;

	}

	private BalloonPool() {
		super();
	}

	@Override
	protected Balloon onAllocatePoolItem() {
		return new Balloon();
	}

	@Override
	protected void onHandleObtainItem(Balloon pItem) {
		pItem.init();
	}

	protected void onHandleRecycleItem(final Balloon e) {
		e.sprite.setVisible(false);
		e.sprite.detachSelf();
		e.clean();
	}
}