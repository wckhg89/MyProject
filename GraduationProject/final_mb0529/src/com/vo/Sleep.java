package com.vo;

public class Sleep {
	int s_num;
	String s_m_id;
	String s_img;
	int s_price;
	String s_session;
	String s_inout;
	String s_content;
	String s_date;
	String s_location;
	String s_location2;
	int s_r_count;
	int s_l_count;

	public Sleep() {
		// TODO Auto-generated constructor stub
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
			String s_date, String s_location2, String s_session,
			String s_location) {
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

	public int gets_num() {
		return s_num;
	}

	public void sets_num(int s_num) {
		this.s_num = s_num;
	}

	public String gets_m_id() {
		return s_m_id;
	}

	public void sets_m_id(String s_m_id) {
		this.s_m_id = s_m_id;
	}

	public String gets_img() {
		return s_img;
	}

	public void sets_img(String s_img) {
		this.s_img = s_img;
	}

	public int gets_price() {
		return s_price;
	}

	public void sets_price(int s_price) {
		this.s_price = s_price;
	}

	public String gets_session() {
		return s_session;
	}

	public void sets_session(String s_session) {
		this.s_session = s_session;
	}

	public String gets_inout() {
		return s_inout;
	}

	public void sets_inout(String s_inout) {
		this.s_inout = s_inout;
	}

	public String gets_content() {
		return s_content;
	}

	public void sets_content(String s_content) {
		this.s_content = s_content;
	}

	public String gets_date() {
		return s_date;
	}

	public void sets_date(String s_date) {
		this.s_date = s_date;
	}

	public String gets_location() {
		return s_location;
	}

	public void sets_location(String s_location) {
		this.s_location = s_location;
	}

	public String gets_location2() {
		return s_location2;
	}

	public void sets_location2(String s_location2) {
		this.s_location2 = s_location2;
	}

	public int gets_r_count() {
		return s_r_count;
	}

	public void sets_r_count(int s_r_count) {
		this.s_r_count = s_r_count;
	}

	public int gets_l_count() {
		return s_l_count;
	}

	public void sets_l_count(int s_l_count) {
		this.s_l_count = s_l_count;
	}

}
