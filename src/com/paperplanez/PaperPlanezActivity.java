package com.paperplanez;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;

public class PaperPlanezActivity extends Activity  implements OnClickListener{
	
    /** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.main);
		
		// Set up click listeners for all the buttons
		View getPlayButton = findViewById(R.id.play_button);
		getPlayButton.setOnClickListener(this);
		View sendExitButton = findViewById(R.id.exit_button);
		sendExitButton.setOnClickListener(this);
		
    }
    
	public void onClick(View v) {
			switch (v.getId()) {
			case R.id.play_button:
				Intent i = new Intent(this, GameActivity.class);
				startActivity(i);
				break;
			case R.id.exit_button:
				try {
					finish();
			} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}