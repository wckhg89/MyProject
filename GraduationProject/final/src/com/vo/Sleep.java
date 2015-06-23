package com.vo;

public class Sleep {
	int s_num;
	String s_m_id;
	String s_img;
	int s_price;
	String s_session;
	String s_inout;
	String s_title;
	String s_content;
	String s_date;
	String s_location;
	String s_location2;
	int s_r_count;
	int s_l_count;

	public Sleep() {
		// TODO Auto-generated constructor stub
	}
	
	public Sleep(int s_num, String s_m_id, String s_img, int s_price,
			String s_session, String s_inout, String s_date, String s_content,
			String s_location, String s_location2, int s_r_count, int s_l_count) {
		super();
		this.s_num = s_num;
		this.s_m_id = s_m_id;
		this.s_img = s_img;
		this.s_price = s_price;
		this.s_session = s_session;
		this.s_inout = s_inout;
		this.s_content = s_content;
		this.s_date = s_date;
		this.s_location = s_location;
		this.s_location2 = s_location2;
		this.s_r_count = s_r_count;
		this.s_l_count = s_l_count;
	}

	public Sleep(String s_m_id, String s_img, int s_price, String s_session,
			String s_inout, String s_content, String s_location,
			String s_location2) {

		this.s_m_id = s_m_id;
		this.s_img = s_img;
		this.s_price = s_price;
		this.s_session = s_session;
		this.s_inout = s_inout;
		this.s_content = s_content;
		this.s_location = s_location;
		this.s_location2 = s_location2;
	}

	/**
	 * Constructor for main page data
	 * 
	 * @param s_num
	 * @param s_m_id
	 * @param s_img
	 */
	public Sleep(int s_num, String s_m_id, String s_img, String s_content,
			String s_date, String s_location2, String s_session, String s_location) {
		this.s_num = s_num;
		this.s_m_id = s_m_id;
		this.s_img = s_img;
		this.s_content = s_content;
		this.s_date = s_date;
		this.s_location2 = s_location2;
		this.s_session = s_session;
		this.s_location = s_location;
	}

	public Sleep(int s_num, String s_m_id, String s_img, int s_price,
			String s_session, String s_inout, String s_content, String s_date,
			String s_location, int s_r_count, int s_l_count) {
		this.s_num = s_num;
		this.s_m_id = s_m_id;
		this.s_img = s_img;
		this.s_price = s_price;
		this.s_session = s_session;
		this.s_inout = s_inout;
		this.s_content = s_content;
		this.s_date = s_date;
		this.s_location = s_location;
		this.s_r_count = s_r_count;
		this.s_l_count = s_l_count;
	}

	public int getS_num() {
		return s_num;
	}

	public void setS_num(int s_num) {
		this.s_num = s_num;
	}

	public String getS_m_id() {
		return s_m_id;
	}

	public void setS_m_id(String s_m_id) {
		this.s_m_id = s_m_id;
	}

	public String getS_img() {
		return s_img;
	}

	public void setS_img(String s_img) {
		this.s_img = s_img;
	}

	public int getS_price() {
		return s_price;
	}

	public void setS_price(int s_price) {
		this.s_price = s_price;
	}

	public String getS_session() {
		return s_session;
	}

	public void setS_session(String s_session) {
		this.s_session = s_session;
	}

	public String getS_inout() {
		return s_inout;
	}

	public void setS_inout(String s_inout) {
		this.s_inout = s_inout;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public String getS_content() {
		return s_content;
	}

	public void setS_content(String s_content) {
		this.s_content = s_content;
	}

	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

	public String getS_location() {
		return s_location;
	}

	public void setS_location(String s_location) {
		this.s_location = s_location;
	}

	public String getS_location2() {
		return s_location2;
	}

	public void setS_location2(String s_location2) {
		this.s_location2 = s_location2;
	}

	public int getS_r_count() {
		return s_r_count;
	}

	public void setS_r_count(int s_r_count) {
		this.s_r_count = s_r_count;
	}

	public int getS_l_count() {
		return s_l_count;
	}

	public void setS_l_count(int s_l_count) {
		this.s_l_count = s_l_count;
	}

	
}
