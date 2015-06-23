package com.example.hw3_b;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_Info extends Fragment {
	String[] friend;
	String[] email;
	String[] tel;
	String[] disc;
	TextView name;
	TextView mail;
	TextView telephone;
	TextView discription;
	Button btnMail;
	Button btnCall;
	Button btnSMS;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_info, container, false);

	}

	public void onStart() {
		super.onStart();
		friend = getResources().getStringArray(R.array.friend_array);
		email = getResources().getStringArray(R.array.friend_email);
		tel = getResources().getStringArray(R.array.friend_tel);
		disc = getResources().getStringArray(R.array.friend_disc);

		ListView friendList = (ListView) getActivity().findViewById(R.id.list);
		ArrayAdapter<String> friendAdapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_list_item_1, friend);

		friendList.setAdapter(friendAdapter);
		name = (TextView) getActivity().findViewById(R.id.name);
		mail = (TextView) getActivity().findViewById(R.id.email);
		telephone = (TextView) getActivity().findViewById(R.id.tel);
		discription = (TextView) getActivity().findViewById(R.id.disc);
		btnMail = (Button) getActivity().findViewById(R.id.send_email);
		btnCall = (Button) getActivity().findViewById(R.id.call);
		btnSMS = (Button) getActivity().findViewById(R.id.sms);

		btnMail.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (mail.getText().length() == 0) {
					Toast.makeText(getActivity(), "Select your friend",
							Toast.LENGTH_SHORT).show();
				} else {
					Intent intent = new Intent(Intent.ACTION_SENDTO, Uri
							.parse("mailto:" + mail.getText().toString()));
					startActivity(intent);
				}
			}
		});
		btnCall.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (telephone.getText().length() == 0) {
					Toast.makeText(getActivity(), "Select your friend",
							Toast.LENGTH_SHORT).show();
				} else {
					Intent intent = new Intent(
							android.content.Intent.ACTION_DIAL, Uri
									.parse("tel:"
											+ telephone.getText().toString()));
					startActivity(intent);
				}
			}
		});
		btnSMS.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (telephone.getText().length() == 0) {
					Toast.makeText(getActivity(), "Select your friend",
							Toast.LENGTH_SHORT).show();
				} else {
					Intent intent = new Intent(Intent.ACTION_SENDTO, Uri
							.parse("smsto:" + telephone.getText().toString()));
					startActivity(intent);
				}
			}
		});

		friendList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
				// TODO Auto-generated method stub
				name.setText(friend[pos]);
				mail.setText(email[pos]);
				telephone.setText(tel[pos]);
				discription.setText(disc[pos]);
			}

		});

	}

}
