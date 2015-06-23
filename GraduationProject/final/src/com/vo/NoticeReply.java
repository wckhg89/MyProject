package com.vo;

public class NoticeReply {
	private int tn_index;
	private int tn_num;
	private String tn_id;
	private String tn_content;
	private String tn_date;
	
	public NoticeReply() {
		// TODO Auto-generated constructor stub
	}

	public int getTn_index() {
		return tn_index;
	}

	public NoticeReply(int r_num, String tn_id, String tn_content) {
		this.tn_num = r_num;
		this.tn_id = tn_id;
		this.tn_content = tn_content;
	}

	public NoticeReply(int tn_index, int tn_num, String tn_id,
			String tn_content, String tn_date) {
		super();
		this.tn_index = tn_index;
		this.tn_num = tn_num;
		this.tn_id = tn_id;
		this.tn_content = tn_content;
		this.tn_date = tn_date;
	}

	public void setTn_index(int tn_index) {
		this.tn_index = tn_index;
	}

	public int getTn_num() {
		return tn_num;
	}

	public void setTn_num(int tn_num) {
		this.tn_num = tn_num;
	}

	public String getTn_id() {
		return tn_id;
	}

	public void setTn_id(String tn_id) {
		this.tn_id = tn_id;
	}

	public String getTn_content() {
		return tn_content;
	}

	public void setTn_content(String tn_content) {
		this.tn_content = tn_content;
	}

	public String getTn_date() {
		return tn_date;
	}

	public void setTn_date(String tn_date) {
		this.tn_date = tn_date;
	}
}
