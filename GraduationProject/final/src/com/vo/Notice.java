package com.vo;

public class Notice {
	private int n_num;
	private String n_title;
	private String n_content;
	private String n_date;
	private int n_count;
	private int n_r_count;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int n_num, String n_title, String n_content, String n_date,
			int n_count, int n_r_count) {
		super();
		this.n_num = n_num;
		this.n_title = n_title;
		this.n_content = n_content;
		this.n_date = n_date;
		this.n_count = n_count;
		this.n_r_count = n_r_count;
	}
	
	public Notice(String n_title, String n_content) {
		this.n_title = n_title;
		this.n_content = n_content;
	}

	public int getN_num() {
		return n_num;
	}


	public void setN_num(int n_num) {
		this.n_num = n_num;
	}

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public String getN_date() {
		return n_date;
	}

	public void setN_date(String n_date) {
		this.n_date = n_date;
	}

	public int getN_count() {
		return n_count;
	}

	public void setN_count(int n_count) {
		this.n_count = n_count;
	}

	public int getN_r_count() {
		return n_r_count;
	}

	public void setN_r_count(int n_r_count) {
		this.n_r_count = n_r_count;
	}
	
	
}
