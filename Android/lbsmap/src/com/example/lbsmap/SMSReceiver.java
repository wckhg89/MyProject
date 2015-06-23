package com.example.lbsmap;

/**
 * Project name : 너 지금어디야?
 * Developer : 200932220 강홍구
 * Develop date : 14년 6월 11일
 * (SMSReceiver)
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

	static String phoneNum = "";
	String code = "";
	String latitude = "";
	String longitude = "";
	String CODE = MainActivity.mNewCode;
	String str = "";
	String[] tmp;

	/**
	 * onReceive method : this method call automate when receiving the messsage
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		Bundle bundle = intent.getExtras();
		SmsMessage[] msgs = null;
		tmp = new String[4];

		if (bundle != null) {
			Object[] pdus = (Object[]) bundle.get("pdus");
			msgs = new SmsMessage[pdus.length];
			for (int i = 0; i < msgs.length; i++) {
				msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
				str += msgs[i].getOriginatingAddress();
				str += " ";
				str += msgs[i].getMessageBody().toString();
			}
		}

		tmp = str.split(" ");
		phoneNum = tmp[0];
		// saving phoneNumber
		code = tmp[1];
		// saving secret code.
		latitude = tmp[2];
		// saving latitude
		longitude = tmp[3];
		// saving longitude

		if (CODE.equals(code)) {
			// if secret code is valid start service(Service_LBS class)
			// 비밀코드가 일치하면 위치정보를 요청받았음을 알리고 서비스를 호출한다.
			// 서비스는 요청받은자의 위도경도를 가져와서 요청한자에게 보낸다.
			Toast.makeText(context, "위치정보를 요청받았습니다.", 0).show();
			Intent intent2 = new Intent(context, Service_LBS.class);
			context.startService(intent2);
			// 서비스 호출(요청받은자의 위도경도와 자신의 핸드폰번호를 보내주어야한다.(?)
		} else if (!CODE.equals(code)) {
			// if secret code isn't valid
			if (code.equals("위치:")) {
				if (latitude.equals("unknown") || longitude.equals("location")) {
					// if you don't know the other's location.
					Toast.makeText(context, "상대방의 위치를 알 수 없습니다.", 0).show();
				} else if (!latitude.equals("unknown")
						|| longitude.equals("location")) {
					// if you know the other's location. you make maker.
					MainActivity.makeMarker(Double.parseDouble(latitude),
							Double.parseDouble(longitude));
					Toast.makeText(context,
							"상대방위치\n위도 : " + latitude + "\n경도 : " + longitude,
							0).show();
				}
			} else {
				Toast.makeText(context, "암호코드가 일치하지 않습니다.", 0).show();
			}
		} else {
			
		}
	}
}
