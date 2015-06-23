package com.example.lbsmap;

/**
 * Project name : 너 지금어디야?
 * Developer : 200932220 강홍구
 * Develop date : 14년 6월 11일
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
		// 서비스 호출됨.
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
			// 위도
			longitude = Double.toString(l.getLongitude());
			// 경도
			mListener = new LocationListener() {
				// make location listener
				@Override
				// 새로 조사된 위치가 location으로 전달되며 이 객체 안에 상세한 위치정보가있다.
				public void onLocationChanged(Location location) {
					// NewsThread.location = location;

					latitude = Double.toString(location.getLatitude());
					// 위도
					longitude = Double.toString(location.getLongitude());
					// 경도
				}

				@Override
				// 제공자의 사용가능성이 불가능
				public void onProviderDisabled(String provider) {
				}

				@Override
				// 제공자의 사용가능성이 가능
				public void onProviderEnabled(String provider) {
				}

				@Override
				// 위치제공자의 상태가 변경될 때마다 호출된다.
				/*
				 * provider : 위치 제공자 status : 현재 위치제공자의 상태
				 */
				public void onStatusChanged(String provider, int status,
						Bundle extras) {
				}

			};
			mLocMan.requestLocationUpdates(mProvider, 300000, 0, mListener);
			// 300000 1000 : 1초 = x : 300초     
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
					// 위도 경도를 가지고왔다면,
					msg.obj = "현재 위치 : " + "\n위도 : " + latitude + "\n경도 : "
							+ longitude;
					// 토스트 띄우기용
					sendSMS(SMSReceiver.phoneNum, "위치: " + latitude
							+ " " + longitude);
					// 요청한자의 핸드폰번호와 위도경도를 메시지로 보낸다.
					mHandler.sendMessage(msg);
				} else {
					sendSMS(MainActivity.mPhoneNumber,
							"위치: unknown location");
					msg.obj = "현재 위치 : 알 수 없음";
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
