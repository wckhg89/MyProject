package com.example.lbsmap;

/**
 * Project name : 너 지금어디야?
 * Developer : 200932220 강홍구
 * Develop date : 14년 6월 11일
 * (MainActivity)
 */
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v4.app.FragmentActivity;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity {

	ActionBar tmp;
	EditText mPhoneNum;
	static EditText mCode;
	static String mPhoneNumber;
	static String mNumberOfPhone;
	String mCode_s;
	SmsManager sms;
	static GoogleMap mMap;
	static LatLng loc;
	SharedPreferences sh_Pref;
	Editor toEdit;
	public static String mNewCode = "";

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tmp = getActionBar();
		tmp.hide();
		// hiding the actionbar.
		mPhoneNum = (EditText) findViewById(R.id.txt_pn);
		// User enter the phonenumber in this edit text.
		mCode = (EditText) findViewById(R.id.txt_code);
		// User enter the secret code in this edit text.
		mMap = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map)).getMap();
		// get the google map for make maker that other people's(such as your
		// friend) location .
		TelephonyManager systemService = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		// get system service for sending sms message.
		mPhoneNumber = systemService.getLine1Number();
		// get my phone number for receiving message including other people's
		// location.

		mPhoneNumber = mPhoneNumber.substring(mPhoneNumber.length() - 10,
				mPhoneNumber.length());
		// your(requesting location poeple) phone number

		mPhoneNumber = "0" + mPhoneNumber;

		applySharedPrefernces();
		// saving secret code

	}

	/**
	 * applySharedPrefernces method : this method exist for saving secret code.
	 */
	public void applySharedPrefernces() {
		sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
		if (sh_Pref != null && sh_Pref.contains("CODE")) {
			mNewCode = sh_Pref.getString("CODE", null);
			mCode.setText(mNewCode);
		}
	}

	/**
	 * sendSMS method : this method exist for sending message to other people
	 * 
	 * @param phoneNumber
	 * @param code
	 */
	private void sendSMS(String phoneNumber, String code) {
		sms = SmsManager.getDefault();
		sms.sendTextMessage(phoneNumber, null, code, null, null);

	}

	/**
	 * makeMarker method : this method exist for make maker which include your
	 * friend location.
	 * 
	 * @param lat
	 * @param lon
	 */
	public static void makeMarker(double lat, double lon) {
		loc = new LatLng(lat, lon);
		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 5));
		mMap.addMarker(new MarkerOptions().position(loc).title(SMSReceiver.phoneNum+"님의 위치입니다.").snippet("여기서뭐해!"));
		
	}

	/**
	 * onClickBtn method : this method exist for click the buttons which '암호수정'
	 * and '위치요청'
	 * 
	 * @param v
	 */
	public void onClickBtn(View v) {
		switch (v.getId()) {
		case R.id.btn_submit:
			// '위치요청' button
			mNumberOfPhone = mPhoneNum.getText().toString();
			mCode_s = mCode.getText().toString();
			if (mNumberOfPhone.length() == 11) {
				/*
				 * if phone number valid sending message your friend this
				 * message include secret code
				 */

				sendSMS(mNumberOfPhone, mCode_s + " " + "위치 요청");// 요청할 핸드폰번호와
																	// 비밀코드를
																	// 보낸다.
				Toast.makeText(this, mNumberOfPhone + "님에게 위치정보를 요청하였습니다.", 0)
						.show();

			} else {
				Toast.makeText(this, "전화번호 양식과 일치하지 않습니다.", 0).show();
			}
			break;
		case R.id.btn_modify:
			// '암호수정' button
			Intent intent = new Intent(this, ModifyCode.class);
			startActivity(intent);
			break;

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
