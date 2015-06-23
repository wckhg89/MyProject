package com.example.lbsmap;

/**
 * Project name : 너 지금어디야?
 * Developer : 200932220 강홍구
 * Develop date : 14년 6월 11일
 * (ModifyCode)
 */
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class ModifyCode extends Activity {
	ActionBar tmp;
	EditText mCode_mod;

	SharedPreferences sh_Pref;
	Editor toEdit;

	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.code_modify);
		tmp = getActionBar();
		tmp.hide();
		// hiding the action bar.
		mCode_mod = (EditText) findViewById(R.id.txt_mod);

	}

	/**
	 * sharedPrefernces method : this method exist for saving your secret code.
	 */
	public void sharedPrefernces() {
		sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
		toEdit = sh_Pref.edit();
		toEdit.putString("CODE", MainActivity.mNewCode);
		toEdit.commit();
		Toast.makeText(this, MainActivity.mNewCode + "로 암호코드가 수정되었습니다.", 0)
				.show();
		MainActivity.mCode.setText(MainActivity.mNewCode);
	}

	/**
	 * onClickBtn method : this method exist for click the button which '수정하기'
	 * 
	 * @param v
	 */
	public void onClickBtn(View v) {
		switch (v.getId()) {

		case R.id.btn_commit:
			MainActivity.mNewCode = mCode_mod.getText().toString();
			if (MainActivity.mNewCode.length() != 0) {
				sharedPrefernces();
				// call sharedPreferences method.
			} else {
				Toast.makeText(this, "암호코드를 입력해주세요.", 0).show();
			}
			break;

		}
	}
}
