package com.swdm.spinoza_game;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.swdm.link.KakaoLink;

public class AppleTreeGame extends Activity {

	ActionBar menu;
	AppleTreeGameView game;
	Tutorial tuto;
	public static AlertDialog dialBox;

	// public boolean isPressBackBtn;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_view);
		startActivity(new Intent(this, Splash.class));
		dialBox = createDialogBox();
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		menu = getActionBar();
		menu.hide();

		// isPressBackBtn = false;

	}

	public AlertDialog createDialogBox() {
		AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
				// set message, title, and icon
				
				.setTitle("게임종료")
				.setMessage("게임을 종료 하시겠습니까?")
				

				// set three option buttons
				.setPositiveButton("아니요",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// whatever should be done when answering "YES"
								// goes here

								//isPressBackBtn = false;
								AppleTreeGameView.startTime = System
										.currentTimeMillis();
								AppleTreeGameView.bossStartTime = System
										.currentTimeMillis();
								AppleTreeThread.isPause = false;

							}
						})// setPositiveButton
				.setNeutralButton("메인으로",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// whatever should be done when answering
								// "CANCEL" goes here
								//isPressBackBtn=false;
								onDestroy();
								if (game != null) {
									game.surfaceDestroyed(null);
									game.destroy();
									AppleTreeThread.m_Sound_Background.stop();
								}
								setContentView(R.layout.first_view);

							}// OnClick
						})// setNeutralButton
				.setNegativeButton("네", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// whatever should be done when answering "NO"
						// goes here
						//isPressBackBtn=false;
						if (game != null) {
							AppleTreeThread.isPause = true;
							game.surfaceDestroyed(null);
						}
						System.exit(0);
					}
				})// setNegativeButton
				.setCancelable(false)
				.create();
		
		return myQuittingDialogBox;
	}// createDialogBox

	public void rank() {
		Intent intent3 = new Intent(this, AppleTreeRanking.class);
		startActivity(intent3);
	}

	public void clickBtn(View v) {
		switch (v.getId()) {
		case R.id.btn_start:
			// game = null;
			game = new AppleTreeGameView(this);
			setContentView(game);
			AppleTreeThread.isPause = false;
			break;
		case R.id.btn_info:
			Intent intent = new Intent(this, TutorialActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_rank:
			Intent intent2 = new Intent(this, AppleTreeRanking.class);
			startActivity(intent2);
			break;
		case R.id.btn_invite:
			KakaoLink kakaoLink = KakaoLink.getLink(getApplicationContext());
			try {
				kakaoLink
						.openKakaoLink(
								this,
								"https://play.google.com/store/apps/details?id=com.swdm.spinoza_game",
								"벌레가 사과나무를 깍아먹고있어요!\n당장 스피노자를 도와 벌레를 퇴치해 주세요!",
								getPackageName(),
								getPackageManager().getPackageInfo(
										getPackageName(), 0).versionName,
								"스피노자의마지막하루", "UTF-8");
			} catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.apple_tree_game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_apple_tree_game,
					container, false);
			return rootView;
		}
	}

	@Override
	public void onBackPressed() {
		// if (isPressBackBtn == false) {
		// isPressBackBtn = true;
		AppleTreeGameView.sumOfBossTime = AppleTreeGameView.bossTime;
		AppleTreeGameView.sumOfTime = AppleTreeGameView.timeOfMin;
		dialBox.show();

		AppleTreeThread.isPause = true;
		// }
		// if(!dialBox.isShowing())
		// {
		// dialBox.dismiss();
		// }
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

}
