package com.example.hw3_b;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Fragment_List extends Fragment {
	String[] friend;
	String[] email;
	String[] tel;
	String[] disc;
	TextView name;
	TextView mail;
	TextView telephone;
	TextView discription;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_list, container, false);
	}

	public void onStart() {
		super.onStart();

		friend = getResources().getStringArray(R.array.friend_array);
		email = getResources().getStringArray(R.array.friend_email);
		tel = getResources().getStringArray(R.array.friend_tel);
		disc = getResources().getStringArray(R.array.friend_disc);

		ListView friendList;
		friendList = (ListView) getActivity().findViewById(R.id.list);
		ArrayAdapter<String> friendAdapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_list_item_1, friend);

		friendList.setAdapter(friendAdapter);
		name = (TextView) getActivity().findViewById(R.id.name);
		mail = (TextView) getActivity().findViewById(R.id.email);
		telephone = (TextView) getActivity().findViewById(R.id.tel);
		discription = (TextView) getActivity().findViewById(R.id.disc);

		friendList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
				/*
				 * User select friend. send intent including index information
				 * to Activity_Desc.
				 */
				Intent intent = new Intent(getActivity(), Activity_Desc.class);
				intent.putExtra("index", pos);
				startActivity(intent);
			}
		});
	}

}
