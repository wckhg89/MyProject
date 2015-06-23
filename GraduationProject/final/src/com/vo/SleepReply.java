package com.vo;

public class SleepReply {
	private int s_r_idx;
	private String s_r_m_id;
	private int s_r_num;
	private String s_r_content;
	private String s_r_date;
	private String m_img;

	

	public SleepReply(int s_r_idx, String s_r_m_id, int s_r_num,
			String s_r_content, String s_r_date) {
		super();
		this.s_r_idx = s_r_idx;
		this.s_r_m_id = s_r_m_id;
		this.s_r_num = s_r_num;
		this.s_r_content = s_r_content;
		this.s_r_date = s_r_date;
	}

	public SleepReply(String s_r_m_id, String s_r_content, String s_r_date) {
		super();

		this.s_r_m_id = s_r_m_id;
		this.s_r_content = s_r_content;
		this.s_r_date = s_r_date;
	}

	public int getS_r_idx() {
		return s_r_idx;
	}

	public void setS_r_idx(int s_r_idx) {
		this.s_r_idx = s_r_idx;
	}

	public String getS_r_m_id() {
		return s_r_m_id;
	}

	public void setS_r_m_id(String s_r_m_id) {
		this.s_r_m_id = s_r_m_id;
	}

	public int getS_r_num() {
		return s_r_num;
	}

	public void setS_r_num(int s_r_num) {
		this.s_r_num = s_r_num;
	}

	public String getS_r_content() {
		return s_r_content;
	}

	public void setS_r_content(String s_r_content) {
		this.s_r_content = s_r_content;
	}

	public String getS_r_date() {
		return s_r_date;
	}

	public void setS_r_date(String s_r_date) {
		this.s_r_date = s_r_date;
	}

	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
	}
	
	

	

}
