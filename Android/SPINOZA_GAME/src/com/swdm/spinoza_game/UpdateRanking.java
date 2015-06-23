package com.swdm.spinoza_game;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jein.song.User;
import com.jein.song.UserService;

//사과
public class UpdateRanking extends Activity {
	ActionBar menu;
	public static AlertDialog dialBox;
	public static AlertDialog dialBox2;
	
	TextView scoreTxt;
	EditText nameTxt;	
	String phone;
	
	long score;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		//전화번호 받기	
		TelephonyManager mTelephonyMgr;
        mTelephonyMgr = (TelephonyManager)
                getSystemService(Context.TELEPHONY_SERVICE); 
        phone = mTelephonyMgr.getLine1Number();
        phone = phone.substring(phone.length()-10,phone.length());
        phone = "0"+phone;
		
//		TelephonyManager mTelephonyMgr;
//        mTelephonyMgr = (TelephonyManager)
//                getSystemService(Context.TELEPHONY_SERVICE); 
//        phone = mTelephonyMgr.getLine1Number();
		
		setContentView(R.layout.update_ranking);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		Intent tmp = getIntent();
		score = tmp.getLongExtra("SCORE", 0);
		scoreTxt = (TextView)findViewById(R.id.txt_score);
		scoreTxt.setText(Long.toString(score));
		//게임뷰 엑티비티로 부터 점수를 받아옵니다.
		
		nameTxt = (EditText)findViewById(R.id.rank_name);
		 
		dialBox = createDialogBox();//백버튼
		dialBox2 = createDialogBox2();//랭킹등록시
		
		menu = getActionBar();
		menu.hide();
	}
	
	public void onClickBtn(View v)
	{
		new AddTask().execute();
		//System.exit(1);
	}
	
	public AlertDialog createDialogBox() {
		AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
		// set message, title, and icon
				.setTitle("랭킹이 등록되지 않았습니다.").setMessage("아직 당신의 점수를 등록하지 못하였습니다.\n그래도 종료하시겠습니까?")
				// set three option buttons
				.setPositiveButton("아니요", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// whatever should be done when answering "YES" goes
						// here
						
					}
				})// setPositiveButton
				.setNegativeButton("네",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// whatever should be done when answering "NO"
								// goes here
								System.exit(0);
							}
						})// setNegativeButton
				.create();
		return myQuittingDialogBox;
	}
	public AlertDialog createDialogBox2() {
		AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
		// set message, title, and icon
				.setTitle("랭킹이 등록되었습니다.").setMessage("내가 몇등인지 궁금하지 않으세요?\n랭킹을 바로 확인해보시겠습니까?")
				// set three option buttons
				.setPositiveButton("아니요", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// whatever should be done when answering "YES" goes
						// here
						System.exit(0);
					}
				})// setPositiveButton
				.setNegativeButton("네",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// whatever should be done when answering "NO"
								// goes here
								Intent intent = new Intent(getApplicationContext(),AppleTreeRanking.class);
								startActivity(intent);
								System.exit(0);
							}
						})// setNegativeButton
				.create();
		return myQuittingDialogBox;
	}
	
	public void onBackPressed() {
		dialBox.show();
	}
	private class AddTask extends AsyncTask<Object, Object, Object>{

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			setProgressBarIndeterminateVisibility(true);
		}

		@Override
		protected Object doInBackground(Object... params) {
			// TODO Auto-generated method stub
			ServerManager sManager = ServerManager.getInstance();
			
			if (nameTxt == null || "".equals(nameTxt)){
				return null;
			}
			
			ArrayList<NameValuePair> paramList = new ArrayList<NameValuePair>();
			NameValuePair param = new BasicNameValuePair(UserService.ACTION, UserService.UPSERT);
			NameValuePair param1 = new BasicNameValuePair(User.TEL_NO, phone);
			NameValuePair param2 = new BasicNameValuePair(User.SCORE, "" + score);
			NameValuePair param3 = new BasicNameValuePair(User.MESSAGE, "" + nameTxt.getText().toString());
			
			paramList.add(param);
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			
			sManager.process("user", paramList, new ArrayList<User>());
			return null;
		}

		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Toast.makeText(getApplicationContext(), "랭킹이 등록되었습니다.", 0).show();
			dialBox2.show();
			nameTxt.setText(null);
			
		}

		
	}
	
}
