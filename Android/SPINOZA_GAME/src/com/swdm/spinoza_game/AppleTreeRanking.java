package com.swdm.spinoza_game;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jein.song.User;
import com.jein.song.UserService;

public class AppleTreeRanking extends Activity {
	ActionBar menu;
	String phone;
	String myRank;
	TextView myRankTxt;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 없애기
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		menu = getActionBar();
		menu.hide();
		// 전화번호 받기
		TelephonyManager mTelephonyMgr;
		mTelephonyMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		phone = mTelephonyMgr.getLine1Number();
		phone = phone.substring(phone.length() - 10, phone.length());
		phone = "0" + phone;

		setContentView(R.layout.rank_view);
		myRank = "Waiting...";
		myRankTxt = (TextView) findViewById(R.id.myranking);

		myRankTxt.setText(myRank);

		new AllListTask().execute();

	}

	class MyListAdapter extends BaseAdapter {
		Context maincon;
		LayoutInflater Inflater;
		ArrayList<User> arSrc;
		int layout;

		public MyListAdapter(Context context, int alayout,
				ArrayList<User> aarSrc) {
			maincon = context;
			Inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			arSrc = aarSrc;
			layout = alayout;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arSrc.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		/**
		 * 이부분에서 수정해주면 내 순위 표시할수있음!!
		 * 
		 */
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			if (convertView == null) {
				convertView = Inflater.inflate(layout, parent, false);
			}

			/**
			 * 우선 나를 식별하는 유일한 키가 핸드폰 번호니깐
			 * 이것을 기준으로 나누었음!
			 * 만일 핸드펀번호가 일지하면!
			 */
			if (phone.equals(arSrc.get(position).getTelNo())) {
				//convertView.setBackgroundColor(Color.LTGRAY);
				//이부분의 레이아웃의 색깔을 바꾼다! 끝!
				TextView ranking = (TextView) convertView
						.findViewById(R.id.rank);
				ranking.setText("" + (position + 1));
				
				TextView name = (TextView) convertView.findViewById(R.id.name);
				name.setText(arSrc.get(position).getMessage());
				
				TextView score = (TextView) convertView
						.findViewById(R.id.score);
				score.setText(arSrc.get(position).getScore());
				
				TextView telNum = (TextView) convertView
						.findViewById(R.id.telnum);
				telNum.setText(arSrc.get(position).getTelNo().substring(0, 7)+"xxxx");
				
			} else {

				TextView ranking = (TextView) convertView
						.findViewById(R.id.rank);
				ranking.setText("" + (position + 1));

				TextView name = (TextView) convertView.findViewById(R.id.name);
				name.setText(arSrc.get(position).getMessage());

				TextView score = (TextView) convertView
						.findViewById(R.id.score);
				score.setText(arSrc.get(position).getScore());
				
				TextView telNum = (TextView) convertView.findViewById(R.id.telnum);
				telNum.setText(arSrc.get(position).getTelNo().substring(0, 7)+"xxxx");
			}

			return convertView;
		}

	}

	public static void sortArray(ArrayList<User> list) {
		User tmp;
		int end = list.size();

		for (int out = 0; out < end; out++) {
			for (int in = 0; in < end - out - 1; in++) {
				if (Integer.parseInt(list.get(in).getScore()) < Integer
						.parseInt(list.get(in + 1).getScore())) {
					tmp = list.get(in);
					list.set(in, list.get(in + 1));
					list.set(in + 1, tmp);
				}
			}
		}

	}

	private class AllListTask extends
			AsyncTask<Object, Object, ArrayList<User>> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			setProgressBarIndeterminateVisibility(true);
		}

		@Override
		protected ArrayList<User> doInBackground(Object... params) {
			// TODO Auto-generated method stub
			ServerManager sManager = ServerManager.getInstance();

			ArrayList<NameValuePair> paramList = new ArrayList<NameValuePair>();

			NameValuePair param = new BasicNameValuePair(UserService.ACTION,
					UserService.ALL_LIST);
			paramList.add(param);

			ArrayList<User> list = (ArrayList<User>) sManager.process("user",
					paramList, new ArrayList<User>()/* 鍮�源≫넻 */);

			return list;

		}

		@Override
		protected void onPostExecute(ArrayList<User> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			sortArray(result);
			MyListAdapter MyAdapter = new MyListAdapter(
					getApplicationContext(), R.layout.ranklist, result);
			ListView MyList;

			MyList = (ListView) findViewById(R.id.list);
			/**
			 * 이 반복문은 내랭킹찾아서 위에 텍스트 뷰에 뿌려줄라고 만듬!!
			 */
			for (int i = 0; i < result.size(); i++) {
				if (result.get(i).getTelNo().equals(phone)) {
					myRank = "순위 : " + (i + 1)+"/"+result.size() + "  별명 : "
							+ result.get(i).getMessage() + "  점수 : "
							+ result.get(i).getScore();
					//
					
				}
			}
			myRankTxt.setText(myRank);
			MyList.setAdapter(MyAdapter);

			setProgressBarIndeterminateVisibility(false);

		}
	}

	public void onBackPressed() {
		System.exit(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
