package com.example.lbsmap;

/**
 * Project name : �� ���ݾ���?
 * Developer : 200932220 ��ȫ��
 * Develop date : 14�� 6�� 11��
 * (SMSReceiver)
 */
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.telephony.SmsManager;
import android.widget.Toast;

public class Service_LBS extends Service {
	boolean mQuit;
	Message msg;
	Geocoder gc;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	/**
	 * onStartCommand : this method called by SMSReceiver class.
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// ���� ȣ���.
		super.onStartCommand(intent, flags, startId);
		mQuit = false;
		NewsThread thread = new NewsThread(this, mHandler);
		thread.start();
		// start thread.
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		Toast.makeText(this, "ServiceEnd", Toast.LENGTH_SHORT).show();
		mQuit = true;
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * inner class thread class
	 * 
	 * @author honggu
	 * 
	 */
	class NewsThread extends Thread {

		Service_LBS mParent;
		Handler mHandler;

		String latitude = "";
		String longitude = "";
		LocationManager mLocMan;
		String mProvider;
		LocationListener mListener;
		String addressString;

		public NewsThread(Service_LBS parent, Handler handler) {

			mParent = parent;
			mHandler = handler;

			mLocMan = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			// make location manager.
			mProvider = mLocMan.getBestProvider(new Criteria(), true);
			// get best provider
			Location l = mLocMan.getLastKnownLocation(mProvider);
			// get last location
			latitude = Double.toString(l.getLatitude());
			// ����
			longitude = Double.toString(l.getLongitude());
			// �浵
			mListener = new LocationListener() {
				// make location listener
				@Override
				// ���� ����� ��ġ�� location���� ���޵Ǹ� �� ��ü �ȿ� ���� ��ġ�������ִ�.
				public void onLocationChanged(Location location) {
					// NewsThread.location = location;

					latitude = Double.toString(location.getLatitude());
					// ����
					longitude = Double.toString(location.getLongitude());
					// �浵
				}

				@Override
				// �������� ��밡�ɼ��� �Ұ���
				public void onProviderDisabled(String provider) {
				}

				@Override
				// �������� ��밡�ɼ��� ����
				public void onProviderEnabled(String provider) {
				}

				@Override
				// ��ġ�������� ���°� ����� ������ ȣ��ȴ�.
				/*
				 * provider : ��ġ ������ status : ���� ��ġ�������� ����
				 */
				public void onStatusChanged(String provider, int status,
						Bundle extras) {
				}

			};
			mLocMan.requestLocationUpdates(mProvider, 300000, 0, mListener);
			// 300000 1000 : 1�� = x : 300��     
		}

		/**
		 * sendSMS method : this method exist for sending message to other
		 * people
		 * 
		 * @param phoneNumber
		 * @param code
		 */
		private void sendSMS(String phoneNumber, String message) {
			SmsManager sms = SmsManager.getDefault();
			sms.sendTextMessage(phoneNumber, null, message, null, null);
		}

		/**
		 * run method : this method run in background thread : sending message
		 * 10 time's terms in 5min. this message include latitude and longitude
		 * 
		 */
		public void run() {
			for (int idx = 0; idx < 10; idx++) {
				msg = new Message();
				msg.what = 0;
				if (latitude.length() != 0 && longitude.length() != 0) {
					// ���� �浵�� ������Դٸ�,
					msg.obj = "���� ��ġ : " + "\n���� : " + latitude + "\n�浵 : "
							+ longitude;
					// �佺Ʈ �����
					sendSMS(SMSReceiver.phoneNum, "��ġ: " + latitude
							+ " " + longitude);
					// ��û������ �ڵ�����ȣ�� �����浵�� �޽����� ������.
					mHandler.sendMessage(msg);
				} else {
					sendSMS(MainActivity.mPhoneNumber,
							"��ġ: unknown location");
					msg.obj = "���� ��ġ : �� �� ����";
					mHandler.sendMessage(msg);
				}
				try {
					Thread.sleep(300000);
					// 50000
				} catch (Exception e) {
					;
				}
			}
		}
	}

	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == 0) {
				String news = (String) msg.obj;
//				Toast.makeText(Service_LBS.this, news, Toast.LENGTH_SHORT)
//						.show();
			}
		}
	};
}
