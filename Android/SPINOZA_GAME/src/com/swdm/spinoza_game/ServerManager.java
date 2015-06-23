package com.swdm.spinoza_game;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jein.song.User;

/*
 * 통신 담당 클래스 
 * - 서버와의 통신을 담당한다.
 * 
 * 서버와의 통신을 책임지는 HttpClient 객체를 생성한다.
 * */
public class ServerManager {
	
	public final static String VERSION = "1.0";
	// public final static String SERVER = "https://jein100song.appspot.com/";
	public final static String SERVER = "https://hong3kang.appspot.com/";
	
//	public final static String SERVER = "http://192.168.0.9:8888/";


	private static ServerManager _instance = new ServerManager(); // 바로 밑에 정의  되있다.
	
	// 통신하기 위한 객체 : 가장 중요
	private HttpClient _httpClient;

	// 다필요없고 결국 _httpClient가 완성됨
	private ServerManager() {
		HttpParams params = new BasicHttpParams();
		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params, "utf-8");
		params.setBooleanParameter("http.protocol.expect-continue", false);

		// scheme 생성 및 SchemRegistry에 등록
		// 스킴은 http(s)같은 프로토콜 스킴에 대한 명세를 담는다.
		SchemeRegistry registry = new SchemeRegistry();
		registry.register(new Scheme("http", PlainSocketFactory
				.getSocketFactory(), 8080));

		final SSLSocketFactory sslSocketFactory = SSLSocketFactory
				.getSocketFactory();
		sslSocketFactory
				.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		registry.register(new Scheme("https", sslSocketFactory, 443));

		// 클라이언트 연결 풀을 관리하는 매니저의 생성자
		ThreadSafeClientConnManager manager = new ThreadSafeClientConnManager(
				params, registry);
		
		// 서버와 통신하기 위해 사용하는 HttpClient 객체의 생성자
		_httpClient = new DefaultHttpClient(manager, params);
	}

	// ServerManager 객체를 가져오는 부분
	public static ServerManager getInstance() {
		synchronized (ServerManager.class) {
			if (_instance == null) {
				_instance = new ServerManager();
			}
		}
		return _instance;
	}

	// 서버에 요청을 보내는 메인 코드이다.
	// httpClient 객체를 사용해 서버로 요청을 전송한다. (전처리와 후처리를 포함)
	public ArrayList<User> process(String postUrl,
			ArrayList<NameValuePair> nameValuePairs, Object object) {
		
		HttpResponse response = null;
		InputStream is = null;
		
		try {
			// 설정한 기본 환경 정보를 사용해 서버에 요청 전송 및 응답 수신
			// request를 준비하기 위해 preProcess를 호출
			response = _httpClient.execute(preProcess(SERVER + postUrl,
					nameValuePairs));
			
			// 서버의 응답으로 부터 콘텐츠 부분에 대한 '입력 스트림' 획득!!
			HttpEntity entityResponse = response.getEntity();
			is = entityResponse.getContent();
			
			// 서버 응답으로부터 획득한 입력 스트림으로부터 문자열 객체를 얻기 위해 후처리
			String result = postProcess(is);
			// 이렇게 얻은 문자열을 구글 라이브러리 gson을 사용해 다시 도메인 객체로 변환.
			//Object ro = new Gson().fromJson(result, object.getClass());
			Gson jsn = new Gson();
			ArrayList<User> ro = jsn.fromJson(result, new TypeToken<ArrayList<User>>(){}.getType());
			
			return ro;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				is.close();
			} catch (Exception e) {
			}
		}
	}

	// 전처리
	// HttpClient.execute(HttpUriRequest request)의 request를 준비하기 위해 호출한다.
	private HttpPost preProcess(String urlStr,
			ArrayList<NameValuePair> nameValuePairs) {
		HttpPost httpPost = new HttpPost(urlStr);
		UrlEncodedFormEntity entityRequest;
		try {
			entityRequest = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		httpPost.setEntity(entityRequest);
		return httpPost;
	}

	// 후처리
	// 서버 응답으로 부터 획득한 입력 스트림으로부터 문자열 객체를 얻기 위해 호출한다.
	private String postProcess(InputStream is) {
		int bufferSize = 1024;
		byte[] buffer = new byte[bufferSize];
		int readByte = 0;
		int totalByte = 0;
		int count = 0;

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(
				bufferSize * 2);

		try {
			while ((readByte = is.read(buffer)) != -1) {
				totalByte += readByte;
				count++;
				byteArrayOutputStream.write(buffer, 0, readByte);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		byte[] lDataBytes = byteArrayOutputStream.toByteArray();
		return new String(lDataBytes);
	}
}
