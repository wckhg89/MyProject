package com.vo;

public class BandReview {
	private int b_rv_idx;
	private String b_rv_m_id;
	private int b_rv_num;
	private String b_rv_img;
	private String b_rv_content;
	private String b_rv_date;

	public BandReview() {
		// TODO Auto-generated constructor stub
	}
	
	public BandReview(int b_rv_idx, String b_rv_m_id, int b_rv_num,
			String b_rv_content, String b_rv_date) {
		super();
		this.b_rv_idx = b_rv_idx;
		this.b_rv_m_id = b_rv_m_id;
		this.b_rv_num = b_rv_num;
		this.b_rv_content = b_rv_content;
		this.b_rv_date = b_rv_date;
	}

	public int getB_rv_idx() {
		return b_rv_idx;
	}

	public String getB_rv_img() {
		return b_rv_img;
	}

	public void setB_rv_img(String b_rv_img) {
		this.b_rv_img = b_rv_img;
	}

	public void setB_rv_idx(int b_rv_idx) {
		this.b_rv_idx = b_rv_idx;
	}

	public String getB_rv_m_id() {
		return b_rv_m_id;
	}

	public void setB_rv_m_id(String b_rv_m_id) {
		this.b_rv_m_id = b_rv_m_id;
	}

	public int getB_rv_num() {
		return b_rv_num;
	}

	public void setB_rv_num(int b_rv_num) {
		this.b_rv_num = b_rv_num;
	}

	public String getB_rv_content() {
		return b_rv_content;
	}

	public void setB_rv_content(String b_rv_content) {
		this.b_rv_content = b_rv_content;
	}

	public String getB_rv_date() {
		return b_rv_date;
	}

	public void setB_rv_date(String b_rv_date) {
		this.b_rv_date = b_rv_date;
	}

	

}
