package com.example.hw3_0319;

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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.os.Build;
/**
 * Home Work 3.
 * Program name : simple ordering application.
 * Developed date : 03/25/14 
 */
public class MainActivity extends ActionBarActivity {
	EditText name;
	EditText phoneNum;
	RadioButton rdBtn1;
	RadioButton rdBtn2;
	RadioButton rdBtn3;
	RadioButton rdBtnSecond1;
	RadioButton rdBtnSecond2;
	CheckBox chkBox1;
	CheckBox chkBox2;
	CheckBox chkBox3;
	Button confirm;
	Toast toast;
	//Define Button and editText

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		name = (EditText) findViewById(R.id.enterName);
		phoneNum = (EditText) findViewById(R.id.phoneNum);
		rdBtn1 = (RadioButton) findViewById(R.id.sel1);
		rdBtn2 = (RadioButton) findViewById(R.id.sel2);
		rdBtn3 = (RadioButton) findViewById(R.id.sel3);
		rdBtnSecond1 = (RadioButton) findViewById(R.id.selSecond1);
		rdBtnSecond2 = (RadioButton) findViewById(R.id.selSecond2);
		chkBox1 = (CheckBox) findViewById(R.id.chk1);
		chkBox2 = (CheckBox) findViewById(R.id.chk2);
		chkBox3 = (CheckBox) findViewById(R.id.chk3);
		confirm = (Button) findViewById(R.id.confrimBtn);
		//create objects

		confirm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				order();
			}
		});

	}

	private void order() {
		String userName = "";
		String phoneNumber = "";
		String menu = "";
		String menu2 = "";
		String option = "";

		userName = name.getText().toString();
		phoneNumber = phoneNum.getText().toString();

		if (rdBtn1.isChecked()) {
			menu = "Â¥Àå¸é";
		}
		if (rdBtn2.isChecked()) {
			menu = "Â«»Í";
		}
		if (rdBtn2.isChecked()) {
			menu = "ººÀº¹ä";
		}
		if (rdBtnSecond1.isChecked()) {
			menu2=" º¸Åë";
		}
		if (rdBtnSecond2.isChecked()) {
			menu2=" °ö¹è±â";
		}
		if (chkBox1.isChecked()) {
			option += " ´Ü¹«Áö ¸¹ÀÌ";
		}
		if (chkBox2.isChecked()) {
			option += " ¸Ê°Ô";
		}
		if (chkBox3.isChecked()) {
			option += " ¹è´Þ";
		}
		if (userName.length() == 0 || phoneNumber.length() == 0
				|| menu.length() == 0 || menu2.length() == 0
				|| option.length() == 0) {
			toast.makeText(this, "Please input all informaiton",
					toast.LENGTH_SHORT).show();
			//If user entered all information, program represent information through toast
		} else {
			toast.makeText(this,
					userName + " " + phoneNumber + " " + menu + menu2 + option,
					toast.LENGTH_SHORT).show();
			//If user isn't entered all information, program represent error message through toast
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
