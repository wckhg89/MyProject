package com.vo;

public class Eat {
	int e_num;
	String e_m_id;
	String e_img;
	int e_price;
	String e_session;
	String e_inout;
	String e_title;
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

	public Eat(int e_num, String e_m_id, String e_img, int e_price,
			String e_session, String e_inout, String e_date, String e_content,
			String e_location, String e_location2, int e_r_count, int e_l_count) {
		super();
		this.e_num = e_num;
		this.e_m_id = e_m_id;
		this.e_img = e_img;
		this.e_price = e_price;
		this.e_session = e_session;
		this.e_inout = e_inout;
		this.e_content = e_content;
		this.e_date = e_date;
		this.e_location = e_location;
		this.e_location2 = e_location2;
		this.e_r_count = e_r_count;
		this.e_l_count = e_l_count;
	}
	public int getE_num() {
		return e_num;
	}

	public void setE_num(int e_num) {
		this.e_num = e_num;
	}

	public String getE_m_id() {
		return e_m_id;
	}

	public void setE_m_id(String e_m_id) {
		this.e_m_id = e_m_id;
	}

	public String getE_img() {
		return e_img;
	}

	public void setE_img(String e_img) {
		this.e_img = e_img;
	}

	public int getE_price() {
		return e_price;
	}

	public void setE_price(int e_price) {
		this.e_price = e_price;
	}

	public String getE_session() {
		return e_session;
	}

	public void setE_session(String e_session) {
		this.e_session = e_session;
	}

	public String getE_inout() {
		return e_inout;
	}

	public void setE_inout(String e_inout) {
		this.e_inout = e_inout;
	}

	public String getE_title() {
		return e_title;
	}

	public void setE_title(String e_title) {
		this.e_title = e_title;
	}

	public String getE_content() {
		return e_content;
	}

	public void setE_content(String e_content) {
		this.e_content = e_content;
	}

	public String getE_date() {
		return e_date;
	}

	public void setE_date(String e_date) {
		this.e_date = e_date;
	}

	public String getE_location() {
		return e_location;
	}

	public void setE_location(String e_location) {
		this.e_location = e_location;
	}

	public String getE_location2() {
		return e_location2;
	}

	public void setE_location2(String e_location2) {
		this.e_location2 = e_location2;
	}

	public int getE_r_count() {
		return e_r_count;
	}

	public void setE_r_count(int e_r_count) {
		this.e_r_count = e_r_count;
	}

	public int getE_l_count() {
		return e_l_count;
	}

	public void setE_l_count(int e_l_count) {
		this.e_l_count = e_l_count;
	}
	
	
	
	
	
}
