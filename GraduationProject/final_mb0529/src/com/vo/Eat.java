package com.vo;

public class Eat {
	int e_num;
	String e_m_id;
	String e_img;
	int e_price;
	String e_session;
	String e_inout;
	String e_content;
	String e_date;
	String e_location;
	String e_location2;
	int e_r_count;
	int e_l_count;
	public Eat() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor for main page data
	 * @param e_num
	 * @param e_m_id
	 * @param e_img
	 */
	public Eat(int e_num, String e_m_id, String e_img, String e_content, String e_date, String e_location2, String e_session, String e_location) {
		this.e_num = e_num;
		this.e_m_id = e_m_id;
		this.e_img = e_img;
		this.e_content = e_content;
		this.e_date = e_date;
		this.e_location2 = e_location2;
		this.e_session = e_session;
		this.e_location = e_location;
	}
	
	public String getE_location2() {
		return e_location2;
	}

	public void setE_location2(String e_location2) {
		this.e_location2 = e_location2;
	}

	public Eat(String e_m_id, String e_img, int e_price, String e_session,
			String e_inout, String e_content, String e_location,
			String e_location2) {
		
		this.e_m_id = e_m_id;
		this.e_img = e_img;
		this.e_price = e_price;
		this.e_session = e_session;
		this.e_inout = e_inout;
		this.e_content = e_content;
		this.e_location = e_location;
		this.e_location2 = e_location2;
	}

	public Eat(int e_num, String e_m_id, String e_img, int e_price,
			String e_session, String e_inout, String e_content, String e_date,
			String e_location, int e_r_count, int e_l_count) {
		this.e_num = e_num;
		this.e_m_id = e_m_id;
		this.e_img = e_img;
		this.e_price = e_price;
		this.e_session = e_session;
		this.e_inout = e_inout;
		this.e_content = e_content;
		this.e_date = e_date;
		this.e_location = e_location;
		this.e_r_count = e_r_count;
		this.e_l_count = e_l_count;
	}
	public int gete_num() {
		return e_num;
	}
	public void sete_num(int e_num) {
		this.e_num = e_num;
	}
	public String gete_m_id() {
		return e_m_id;
	}
	public void sete_m_id(String e_m_id) {
		this.e_m_id = e_m_id;
	}
	public String gete_img() {
		return e_img;
	}
	public void sete_img(String e_img) {
		this.e_img = e_img;
	}
	public int gete_price() {
		return e_price;
	}
	public void sete_price(int e_price) {
		this.e_price = e_price;
	}
	public String gete_session() {
		return e_session;
	}
	public void sete_session(String e_session) {
		this.e_session = e_session;
	}
	public String gete_inout() {
		return e_inout;
	}
	public void sete_inout(String e_inout) {
		this.e_inout = e_inout;
	}
	public String gete_content() {
		return e_content;
	}
	public void sete_content(String e_content) {
		this.e_content = e_content;
	}
	public String gete_date() {
		return e_date;
	}
	public void sete_date(String e_date) {
		this.e_date = e_date;
	}
	public String gete_location() {
		return e_location;
	}
	public void sete_location(String e_location) {
		this.e_location = e_location;
	}
	public int gete_r_count() {
		return e_r_count;
	}
	public void sete_r_count(int e_r_count) {
		this.e_r_count = e_r_count;
	}
	public int gete_l_count() {
		return e_l_count;
	}
	public void sete_l_count(int e_l_count) {
		this.e_l_count = e_l_count;
	}
	
	
}
