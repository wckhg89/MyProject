package com.vo;

public class Info {
	private int i_num;
	private String i_id;
	private String i_title;
	private String i_content;
	private String i_date;
	private int i_count;
	private int i_r_count;
	
	public Info() {
		// TODO Auto-generated constructor stub
	}

	public Info(int i_num, String i_id, String i_title, String i_content,
			String i_date, int i_count, int i_r_count) {
		this.i_num = i_num;
		this.i_id = i_id;
		this.i_title = i_title;
		this.i_content = i_content;
		this.i_date = i_date;
		this.i_count = i_count;
		this.i_r_count = i_r_count;
	}

	public Info(String i_id, String i_title, String i_content) {
		this.i_id = i_id;
		this.i_title = i_title;
		this.i_content = i_content;
	}

	public int getI_num() {
		return i_num;
	}

	public void setI_num(int i_num) {
		this.i_num = i_num;
	}

	public String getI_id() {
		return i_id;
	}

	public void setI_id(String i_id) {
		this.i_id = i_id;
	}

	public String getI_title() {
		return i_title;
	}

	public void setI_title(String i_title) {
		this.i_title = i_title;
	}

	public String getI_content() {
		return i_content;
	}

	public void setI_content(String i_content) {
		this.i_content = i_content;
	}

	public String getI_date() {
		return i_date;
	}

	public void setI_date(String i_date) {
		this.i_date = i_date;
	}

	public int getI_count() {
		return i_count;
	}

	public void setI_count(int i_count) {
		this.i_count = i_count;
	}

	public int getI_r_count() {
		return i_r_count;
	}

	public void setI_r_count(int i_r_count) {
		this.i_r_count = i_r_count;
	}
	
}
