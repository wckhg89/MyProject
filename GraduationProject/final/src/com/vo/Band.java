package com.vo;

public class Band {

	private int b_num;
	private String b_m_id;
	private String b_category;
	private String b_title;
	private String b_img1;
	private String b_content;
	private String b_date;
	private int b_people;
	private String b_when;
	private String b_where;
	private String b_lon;
	private String b_lat;
	public String getB_lon() {
		return b_lon;
	}


	public void setB_lon(String b_lon) {
		this.b_lon = b_lon;
	}


	public String getB_lat() {
		return b_lat;
	}


	public void setB_lat(String b_lat) {
		this.b_lat = b_lat;
	}
	private int b_l_count;
	private int b_r_count;
	private int b_rv_count;
	
	public Band() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Band(String b_m_id, String b_category, String b_title,
			String b_img1, String b_content,  int b_people,
			String b_when, String b_where) {
		super();
		this.b_m_id = b_m_id;
		this.b_category = b_category;
		this.b_title = b_title;
		this.b_img1 = b_img1;
		this.b_content = b_content;
		this.b_people = b_people;
		this.b_when = b_when;
		this.b_where = b_where;
	}
	
	
	
	public Band(int b_num, String b_m_id, String b_category, String b_title,
			String b_img1, String b_content, String b_when) {
		super();
		this.b_num = b_num;
		this.b_m_id = b_m_id;
		this.b_category = b_category;
		this.b_title = b_title;
		this.b_img1 = b_img1;
		this.b_content = b_content;
		this.b_when = b_when;
	}



	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getB_m_id() {
		return b_m_id;
	}
	public void setB_m_id(String b_m_id) {
		this.b_m_id = b_m_id;
	}
	public String getB_category() {
		return b_category;
	}
	public void setB_category(String b_category) {
		this.b_category = b_category;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_img1() {
		return b_img1;
	}
	public void setB_img1(String b_img1) {
		this.b_img1 = b_img1;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public int getB_people() {
		return b_people;
	}
	public void setB_people(int b_people) {
		this.b_people = b_people;
	}
	public String getB_when() {
		return b_when;
	}
	public void setB_when(String b_when) {
		this.b_when = b_when;
	}
	public String getB_where() {
		return b_where;
	}
	public void setB_where(String b_where) {
		this.b_where = b_where;
	}
	public int getB_l_count() {
		return b_l_count;
	}
	public void setB_l_count(int b_l_count) {
		this.b_l_count = b_l_count;
	}
	public int getB_r_count() {
		return b_r_count;
	}
	public void setB_r_count(int b_r_count) {
		this.b_r_count = b_r_count;
	}
	public int getB_rv_count() {
		return b_rv_count;
	}
	public void setB_rv_count(int b_rv_count) {
		this.b_rv_count = b_rv_count;
	}

	

}
