package com.swdm.spinoza_game;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.WindowManager;

public class TutorialActivity extends Activity {
	ActionBar menu;
	public static AlertDialog dialBox;
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		dialBox = createDialogBox();
		menu = getActionBar();
		menu.hide();
		setContentView(new Tutorial(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.apple_tree_game, menu);
		return true;
	}

	public AlertDialog createDialogBox() {
		AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
		// set message, title, and icon
				.setTitle("����!������ �̿���!").setMessage("���� ���ӿ� ���� �ٹ���� ���߾�� ! �׷��� Ʃ�丮�� ��带 �����ðڽ��ϱ�?")
				// set three option buttons
				.setPositiveButton("�ƴϿ�", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// whatever should be done when answering "YES" goes
						// here
						
					}
				})// setPositiveButton
				.setNegativeButton("��",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// whatever should be done when answering "NO"
								// goes here
								System.exit(0);
							}
						})// setNegativeButton
				.create();
		return myQuittingDialogBox;
	}
	
	public void onBackPressed() {
		dialBox.show();
	}

}
