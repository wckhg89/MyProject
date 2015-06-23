package com.vo;

public class Pride {
	private int p_num;
	private String p_id;
	private String p_title;
	private String p_content;
	private String p_date;
	private int p_count;
	private int p_r_count;
	
	public Pride() {
		// TODO Auto-generated constructor stub
	}
	
	public Pride(String p_id, String p_title, String p_content) {
		this.p_id = p_id;
		this.p_title = p_title;
		this.p_content = p_content;
	}

	public Pride(int p_num, String p_id, String p_title, String p_content,
			String p_date, int p_count, int p_r_count) {
		this.p_num = p_num;
		this.p_id = p_id;
		this.p_title = p_title;
		this.p_content = p_content;
		this.p_date = p_date;
		this.p_count = p_count;
		this.p_r_count = p_r_count;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
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

	public int getP_count() {
		return p_count;
	}

	public void setP_count(int p_count) {
		this.p_count = p_count;
	}

	public int getP_r_count() {
		return p_r_count;
	}

	public void setP_r_count(int p_r_count) {
		this.p_r_count = p_r_count;
	}
	
	
}
