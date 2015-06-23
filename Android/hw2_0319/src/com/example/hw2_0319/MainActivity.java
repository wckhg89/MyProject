package com.example.hw2_0319;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.os.Build;
/**
 * Home Work 2.
 * Program name : simple tip calculator.
 * Developed date : 03/25/14 
 */

public class MainActivity extends ActionBarActivity {
	EditText totAmount;
	EditText otherPer;
	Button calBtn;
	RadioButton rdBtn15;
	RadioButton rdBtn20;
	RadioButton rdBtnOther;
	Toast toast;
	//Define Button, RadioButton and EditText

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		totAmount = (EditText) findViewById(R.id.Amount);
		otherPer = (EditText) findViewById(R.id.otherInput);
		calBtn = (Button) findViewById(R.id.btnCal);
		rdBtn15 = (RadioButton) findViewById(R.id.per15);
		rdBtn20 = (RadioButton) findViewById(R.id.per20);
		rdBtnOther = (RadioButton) findViewById(R.id.perOther);
		//Create objects
		calBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				calculate();
			}
		});
	}

	private void calculate() {
		double result = 0;
		String output = null;

		if (totAmount.getText().length() == 0) {
			toast.makeText(this, "Enter total amount", toast.LENGTH_SHORT)
					.show();
		}

		else if (rdBtn15.isChecked()) {
			/*
			 * If user want to calculate tip at 15 percentage,
			 * Program calculate tip and represent tip and amount of paying money through toast
			 */
			result = Double.parseDouble(totAmount.getText().toString()) * 0.15;
			output = Double.toString(result);

			toast.makeText(
					this,
					"Tip: "
							+ output
							+ "\n"
							+ "Total: "
							+ (result + Double.parseDouble(totAmount.getText()
									.toString())), toast.LENGTH_SHORT).show();
		}

		else if (rdBtn20.isChecked()) {
			/*
			 * If user want to calculate tip at 20 percentage,
			 * Program calculate tip and represent tip and amount of paying money through toast
			 */
			result = Double.parseDouble(totAmount.getText().toString()) * 0.20;
			output = Double.toString(result);

			toast.makeText(
					this,
					"Tip: "
							+ output
							+ "\n"
							+ "Total: "
							+ (result + Double.parseDouble(totAmount.getText()
									.toString())), toast.LENGTH_SHORT).show();
		}

		else if (rdBtnOther.isChecked()) {
			/*
			 * If user want to calculate tip at other percentage,
			 * Program calculate tip and represent tip and amount of paying money through toast
			 */
			if (otherPer.getText().toString().equalsIgnoreCase("")) {
				toast.makeText(this, "Enter the percentage", toast.LENGTH_SHORT)
						.show();
			} else {
				double tmp = (Double.parseDouble(otherPer.getText().toString()));
				tmp = tmp / 100;
				result = Double.parseDouble(totAmount.getText().toString())
						* tmp;
				output = Double.toString(result);

				toast.makeText(
						this,
						"Tip: "
								+ output
								+ "\n"
								+ "Total: "
								+ (result + Double.parseDouble(totAmount
										.getText().toString())),
						toast.LENGTH_SHORT).show();
			}
		}
		else
		{
			toast.makeText(this, "Please Click Button", toast.LENGTH_SHORT)
			.show();
		}

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
