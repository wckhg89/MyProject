package com.example.hw3_b;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Desc extends Activity {
	String[] friend;
	String[] email;
	String[] tel;
	String[] disc;

	TextView name;
	TextView mail;
	TextView telephone;
	TextView discription;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_info);

		friend = getResources().getStringArray(R.array.friend_array);
		email = getResources().getStringArray(R.array.friend_email);
		tel = getResources().getStringArray(R.array.friend_tel);
		disc = getResources().getStringArray(R.array.friend_disc);

		name = (TextView) findViewById(R.id.name);
		mail = (TextView) findViewById(R.id.email);
		telephone = (TextView) findViewById(R.id.tel);
		discription = (TextView) findViewById(R.id.disc);

		int index = getIntent().getExtras().getInt("index");

		name.setText(friend[index]);
		mail.setText(email[index]);
		telephone.setText(tel[index]);
		discription.setText(disc[index]);

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.send_email:
			/*
			 * sending email
			 */
			if (mail.getText().length() == 0) {
				Toast.makeText(this, "Select your friend", Toast.LENGTH_SHORT)
						.show();
			} else {
				Intent intent = new Intent(Intent.ACTION_SENDTO,
						Uri.parse("mailto:" + mail.getText().toString()));
				startActivity(intent);
			}
			break;
		case R.id.call:
			/*
			 * calling
			 */
			if (telephone.getText().length() == 0) {
				Toast.makeText(this, "Select your friend", Toast.LENGTH_SHORT)
						.show();
			} else {
				Intent intent = new Intent(android.content.Intent.ACTION_DIAL,
						Uri.parse("tel:" + telephone.getText().toString()));
				startActivity(intent);
			}
			break;
		case R.id.sms:
			/*
			 * sending sms
			 */
			if (telephone.getText().length() == 0) {
				Toast.makeText(this, "Select your friend", Toast.LENGTH_SHORT)
						.show();
			} else {
				Intent intent = new Intent(Intent.ACTION_SENDTO,
						Uri.parse("smsto:" + telephone.getText().toString()));
				startActivity(intent);
			}
			break;
		}
	}
}
