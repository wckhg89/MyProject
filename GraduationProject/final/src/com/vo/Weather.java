package com.vo;

public class Weather {
	int data;
	String city;
	private String mode;
	private String numEf; // n �� �� ����
	private String tmEf; //�� �� ��
	private String wf; // ��������
	private String tmn; // ���� �µ�
	private String tmx; // �ְ� �µ�
	private String reliability; //�ŷڵ�
	
	public Weather() {
		// TODO Auto-generated constructor stub
	}
	
	public Weather(int data, String city, String mode, String numEf,
			String tmEf, String wf, String tmn, String tmx, String reliability) {
		super();
		this.data = data;
		this.city = city;
		this.mode = mode;
		this.numEf = numEf;
		this.tmEf = tmEf;
		this.wf = wf;
		this.tmn = tmn;
		this.tmx = tmx;
		this.reliability = reliability;
	}


	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}


	public String getNumEf() {
		return numEf;
	}


	public void setNumEf(String numEf) {
		this.numEf = numEf;
	}


	public String getTmEf() {
		return tmEf;
	}


	public void setTmEf(String tmEf) {
		this.tmEf = tmEf;
	}


	public String getWf() {
		return wf;
	}


	public void setWf(String wf) {
		this.wf = wf;
	}


	public String getTmn() {
		return tmn;
	}


	public void setTmn(String tmn) {
		this.tmn = tmn;
	}


	public String getTmx() {
		return tmx;
	}


	public void setTmx(String tmx) {
		this.tmx = tmx;
	}


	public String getReliability() {
		return reliability;
	}


	public void setReliability(String reliability) {
		this.reliability = reliability;
	}
	
	
	
	
}
