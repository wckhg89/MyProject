package com.example.hw1_0319;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;
/**
 * Home Work 1.
 * Program name : simple counter.
 * Developed date : 03/25/14 
 */
public class MainActivity extends ActionBarActivity {
	private static int resultCount = 0;

	EditText resultEdit;
	Button countUp;
	Button countDown;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		resultEdit = (EditText) findViewById(R.id.resultEdit);
		countUp = (Button) findViewById(R.id.countUp);
		countDown = (Button) findViewById(R.id.countDown);

		countUp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				countUp();
			}
		});

		countDown.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				countDown();
			}
		});
	}

	private void countUp() {
		/*
		 * If user click countUp button,
		 * present value is added one.
		 */
		resultCount++;
		resultEdit.setText(Integer.toString(resultCount));
	}

	private void countDown() {
		/*
		 * If user click countUp button,
		 * present value is minused one.
		 */
		resultCount--;
		resultEdit.setText(Integer.toString(resultCount));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
