package com.vo;

public class PlayReply {
	private int p_r_idx;
	private String p_r_m_id;
	private int p_r_num;
	private String p_r_content;
	private String p_r_date;
	private String m_img;

	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
	}

	public PlayReply(int p_r_idx, String p_r_m_id, int p_r_num,
			String p_r_content, String p_r_date) {
		super();
		this.p_r_idx = p_r_idx;
		this.p_r_m_id = p_r_m_id;
		this.p_r_num = p_r_num;
		this.p_r_content = p_r_content;
		this.p_r_date = p_r_date;
	}

	public PlayReply(String p_r_m_id, String p_r_content, String p_r_date) {
		super();

		this.p_r_m_id = p_r_m_id;
		this.p_r_content = p_r_content;
		this.p_r_date = p_r_date;
	}

	public int getP_r_idx() {
		return p_r_idx;
	}

	public void setP_r_idx(int p_r_idx) {
		this.p_r_idx = p_r_idx;
	}

	public String getP_r_m_id() {
		return p_r_m_id;
	}

	public void setP_r_m_id(String p_r_m_id) {
		this.p_r_m_id = p_r_m_id;
	}

	public int getP_r_num() {
		return p_r_num;
	}

	public void setP_r_num(int p_r_num) {
		this.p_r_num = p_r_num;
	}

	public String getP_r_content() {
		return p_r_content;
	}

	public void setP_r_content(String p_r_content) {
		this.p_r_content = p_r_content;
	}

	public String getP_r_date() {
		return p_r_date;
	}

	public void setP_r_date(String p_r_date) {
		this.p_r_date = p_r_date;
	}

}
