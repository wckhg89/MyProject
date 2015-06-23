package com.vo;

public class EatReply {
	private int e_r_idx;
	private String e_r_m_id;
	private int e_r_num;
	private String e_r_content;
	private String e_r_date;
	private String m_img;

	

	public EatReply(int e_r_idx, String e_r_m_id, int e_r_num,
			String e_r_content, String e_r_date) {
		super();
		this.e_r_idx = e_r_idx;
		this.e_r_m_id = e_r_m_id;
		this.e_r_num = e_r_num;
		this.e_r_content = e_r_content;
		this.e_r_date = e_r_date;
	}

	public EatReply(String e_r_m_id, String e_r_content, String e_r_date) {
		super();

		this.e_r_m_id = e_r_m_id;
		this.e_r_content = e_r_content;
		this.e_r_date = e_r_date;
	}
	
	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
	}

	public int getE_r_idx() {
		return e_r_idx;
	}

	public void setE_r_idx(int e_r_idx) {
		this.e_r_idx = e_r_idx;
	}

	public String getE_r_m_id() {
		return e_r_m_id;
	}

	public void setE_r_m_id(String e_r_m_id) {
		this.e_r_m_id = e_r_m_id;
	}

	public int getE_r_num() {
		return e_r_num;
	}

	public void setE_r_num(int e_r_num) {
		this.e_r_num = e_r_num;
	}

	public String getE_r_content() {
		return e_r_content;
	}

	public void setE_r_content(String e_r_content) {
		this.e_r_content = e_r_content;
	}

	public String getE_r_date() {
		return e_r_date;
	}

	public void setE_r_date(String e_r_date) {
		this.e_r_date = e_r_date;
	}

	

}
