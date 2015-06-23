package com.swdm.spinoza_game;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class Splash extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		
		Handler hd = new Handler();
		hd.postDelayed(new Runnable() {

			@Override
			public void run() {
				
				finish(); // 5 초후 이미지를 닫아버림
			}
		}, 3000);

	}
}