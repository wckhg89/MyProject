package com.vo;

public class SocialReplyList {
	private String s_img;
	private int s_num;
	private String s_id;
	private String s_title;
	private String sr_id;
	private String m_img;
	private String sr_content;
	
	public SocialReplyList() {
	}

	public SocialReplyList(String s_img, int s_num, String s_id,
			String s_title, String sr_id, String m_img, String sr_content) {
		this.s_img = s_img;
		this.s_num = s_num;
		this.s_id = s_id;
		this.s_title = s_title;
		this.sr_id = sr_id;
		this.m_img = m_img;
		this.sr_content = sr_content;
	}

	public String getS_img() {
		return s_img;
	}

	public void setS_img(String s_img) {
		this.s_img = s_img;
	}

	public int getS_num() {
		return s_num;
	}

	public void setS_num(int s_num) {
		this.s_num = s_num;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public String getSr_id() {
		return sr_id;
	}

	public void setSr_id(String sr_id) {
		this.sr_id = sr_id;
	}

	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
	}

	public String getSr_content() {
		return sr_content;
	}

	public void setSr_content(String sr_content) {
		this.sr_content = sr_content;
	}

	
	
}
