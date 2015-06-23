package com.example.lbsmap;

/**
 * Project name : �� ���ݾ���?
 * Developer : 200932220 ��ȫ��
 * Develop date : 14�� 6�� 11��
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
		Toast.makeText(this, MainActivity.mNewCode + "�� ��ȣ�ڵ尡 �����Ǿ����ϴ�.", 0)
				.show();
		MainActivity.mCode.setText(MainActivity.mNewCode);
	}

	/**
	 * onClickBtn method : this method exist for click the button which '�����ϱ�'
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
				Toast.makeText(this, "��ȣ�ڵ带 �Է����ּ���.", 0).show();
			}
			break;

		}
	}
}
