package com.vo;

public class Play {
	int p_num;
	String p_m_id;
	String p_img;
	int p_price;
	String p_session;
	String p_inout;
	String p_title;
	String p_content;
	String p_date;
	String p_location;
	String p_location2;

	public Play() {
		// TODO Auto-generated constructor stub
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getP_location2() {
		return p_location2;
	}

	public void setP_location2(String p_location2) {
		this.p_location2 = p_location2;
	}

	int p_r_count;
	int p_l_count;

	/**
	 * Constructor for main page data
	 * 
	 * @param p_num
	 * @param p_m_id
	 * @param p_img
	 */
	public Play(int p_num, String p_m_id, String p_img, String p_content,
			String p_date, String p_location2, String p_session,
			String p_location) {
		this.p_num = p_num;
		this.p_m_id = p_m_id;
		this.p_img = p_img;
		this.p_content = p_content;
		this.p_date = p_date;
		this.p_location2 = p_location2;
		this.p_session = p_session;
		this.p_location = p_location;
	}

	public Play(String p_m_id, String p_img, int p_price, String p_session,
			String p_inout, String p_content, String p_location,
			String p_location2) {
		this.p_m_id = p_m_id;
		this.p_img = p_img;
		this.p_price = p_price;
		this.p_session = p_session;
		this.p_inout = p_inout;
		this.p_content = p_content;
		this.p_location = p_location;
		this.p_location2 = p_location2;

	}

	public Play(int p_num, String p_m_id, String p_img, int p_price,
			String p_session, String p_inout, String p_content, String p_date,
			String p_location, int p_r_count, int p_l_count) {
		this.p_num = p_num;
		this.p_m_id = p_m_id;
		this.p_img = p_img;
		this.p_price = p_price;
		this.p_session = p_session;
		this.p_inout = p_inout;
		this.p_content = p_content;
		this.p_date = p_date;
		this.p_location = p_location;
		this.p_r_count = p_r_count;
		this.p_l_count = p_l_count;
	}

	public Play(int p_num, String p_m_id, String p_img, int p_price,
			String p_session, String p_inout, String p_date, String p_content,
			String p_location, String p_location2, int p_r_count, int p_l_count) {
		this.p_num = p_num;
		this.p_m_id = p_m_id;
		this.p_img = p_img;
		this.p_price = p_price;
		this.p_session = p_session;
		this.p_inout = p_inout;
		this.p_content = p_content;
		this.p_date = p_date;
		this.p_location = p_location;
		this.p_location2 = p_location2;
		this.p_r_count = p_r_count;
		this.p_l_count = p_l_count;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getP_m_id() {
		return p_m_id;
	}

	public void setP_m_id(String p_m_id) {
		this.p_m_id = p_m_id;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_session() {
		return p_session;
	}

	public void setP_session(String p_session) {
		this.p_session = p_session;
	}

	public String getP_inout() {
		return p_inout;
	}

	public void setP_inout(String p_inout) {
		this.p_inout = p_inout;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public String getP_date() {
		return p_date;
	}

	public void setP_date(String p_date) {
		this.p_date = p_date;
	}

	public String getP_location() {
		return p_location;
	}

	public void setP_location(String p_location) {
		this.p_location = p_location;
	}

	public int getP_r_count() {
		return p_r_count;
	}

	public void setP_r_count(int p_r_count) {
		this.p_r_count = p_r_count;
	}

	public int getP_l_count() {
		return p_l_count;
	}

	public void setP_l_count(int p_l_count) {
		this.p_l_count = p_l_count;
	}

}
