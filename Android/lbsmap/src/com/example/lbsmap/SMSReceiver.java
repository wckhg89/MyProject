package com.example.lbsmap;

/**
 * Project name : �� ���ݾ���?
 * Developer : 200932220 ��ȫ��
 * Develop date : 14�� 6�� 11��
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
			// ����ڵ尡 ��ġ�ϸ� ��ġ������ ��û�޾����� �˸��� ���񽺸� ȣ���Ѵ�.
			// ���񽺴� ��û�������� �����浵�� �����ͼ� ��û���ڿ��� ������.
			Toast.makeText(context, "��ġ������ ��û�޾ҽ��ϴ�.", 0).show();
			Intent intent2 = new Intent(context, Service_LBS.class);
			context.startService(intent2);
			// ���� ȣ��(��û�������� �����浵�� �ڽ��� �ڵ�����ȣ�� �����־���Ѵ�.(?)
		} else if (!CODE.equals(code)) {
			// if secret code isn't valid
			if (code.equals("��ġ:")) {
				if (latitude.equals("unknown") || longitude.equals("location")) {
					// if you don't know the other's location.
					Toast.makeText(context, "������ ��ġ�� �� �� �����ϴ�.", 0).show();
				} else if (!latitude.equals("unknown")
						|| longitude.equals("location")) {
					// if you know the other's location. you make maker.
					MainActivity.makeMarker(Double.parseDouble(latitude),
							Double.parseDouble(longitude));
					Toast.makeText(context,
							"������ġ\n���� : " + latitude + "\n�浵 : " + longitude,
							0).show();
				}
			} else {
				Toast.makeText(context, "��ȣ�ڵ尡 ��ġ���� �ʽ��ϴ�.", 0).show();
			}
		} else {
			
		}
	}
}
