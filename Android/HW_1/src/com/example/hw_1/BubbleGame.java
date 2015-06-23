package com.example.hw_1;

import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class BubbleGame extends Activity {

	ActionBar actionbar = null;
	public static AlertDialog dialBox;
	BubbleGameView game;

	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		game = new BubbleGameView(this);
		actionbar = getActionBar();
		actionbar.hide();
		setContentView(game);
		dialBox = createDialogBox();
	}
	/**
	 * click the back button popup the dialbox
	 */
	public void onBackPressed() {
		dialBox.show();
		BubbleGameThread.isEnd = true;
	}
	/**
	 * Dialbox method
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
								BubbleGameThread.isEnd = false;
								
							}
						})// setPositiveButton
				.setNeutralButton("다시하기",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// whatever should be done when answering
								// "CANCEL" goes here
								game.init();
								BubbleGameThread.isEnd = false;
							}// OnClick
						})// setNeutralButton
				.setNegativeButton("네", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// whatever should be done when answering "NO"
						// goes here
						BubbleGameThread.isEnd = true;
						System.exit(0);
					}
				})// setNegativeButton
				.create();
		return myQuittingDialogBox;
	}// createDialogBox

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bubble_game, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_bubble_game,
					container, false);
			return rootView;
		}
	}

}
