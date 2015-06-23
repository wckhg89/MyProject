package com.example.hw_2;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class PathGame extends ActionBarActivity {
	PathGameView path;
	public static boolean block_chk = false;
	public static AlertDialog dialBox;
	android.app.ActionBar actionbar;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		actionbar = getActionBar();
		actionbar.hide();
		dialBox = createDialogBox();
		/*
		 * create new map while path is exist
		 */
		while (true) {
			path = new PathGameView(this);
			path.initRightPath(0, 0);
			if (block_chk == true) {
				block_chk = false;
				break;
			}

		}
		setContentView(path);

	}
	/**
	 * if click the back button pop-up the dialbox.
	 */
	public void onBackPressed() {
		dialBox.show();
		PathGameThread.isPause = true;

	}
	/**
	 * dialbox method
	 */
	private AlertDialog createDialogBox() {
		AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
				// set message, title, and icon
				.setTitle("게임종료")
				.setMessage("게임을 종료 하시겠습니까?")

				// set three option buttons
				.setPositiveButton("아니요",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								PathGameThread.isPause = false;

							}
						})// setPositiveButton
				
				.setNegativeButton("네", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// whatever should be done when answering "NO"
						// goes here
						PathGameThread.isPause = true;
						System.exit(0);
					}
				})// setNegativeButton
				.create();
		return myQuittingDialogBox;
	}// createDialogBox

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.path_game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
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
			View rootView = inflater.inflate(R.layout.fragment_path_game,
					container, false);
			return rootView;
		}
	}

}
