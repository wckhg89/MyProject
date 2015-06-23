package com.vo;

public class CommunityReply {
	private int tc_index;
	private int p_num;
	private int i_num;
	private String tc_id;
	private String tc_content;
	private String tc_date;
	
	public CommunityReply() {
		// TODO Auto-generated constructor stub
	}

	//info 게시판 댓글
	public CommunityReply(int p_num, int i_num, String tc_id,
			String tc_content) {
		this.p_num = p_num;
		this.i_num = i_num;
		this.tc_id = tc_id;
		this.tc_content = tc_content;
	}


	//pride 게시판의 댓글!
	public CommunityReply(int p_num, String tc_id, String tc_content) {
		this.p_num = p_num;
		this.tc_id = tc_id;
		this.tc_content = tc_content;
	}

	public CommunityReply(int tc_index, int p_num, int i_num, String tc_id,
			String tc_content, String tc_date) {
		super();
		this.tc_index = tc_index;
		this.p_num = p_num;
		this.i_num = i_num;
		this.tc_id = tc_id;
		this.tc_content = tc_content;
		this.tc_date = tc_date;
	}

	public CommunityReply(int tc_index, int p_num, String tc_id,
			String tc_content, String tc_date) {
		super();
		this.tc_index = tc_index;
		this.p_num = p_num;
		this.tc_id = tc_id;
		this.tc_content = tc_content;
		this.tc_date = tc_date;
	}

	public int getTc_index() {
		return tc_index;
	}

	public void setTc_index(int tc_index) {
		this.tc_index = tc_index;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public int getI_num() {
		return i_num;
	}

	public void setI_num(int i_num) {
		this.i_num = i_num;
	}

	public String getTc_id() {
		return tc_id;
	}

	public void setTc_id(String tc_id) {
		this.tc_id = tc_id;
	}

	public String getTc_content() {
		return tc_content;
	}

	public void setTc_content(String tc_content) {
		this.tc_content = tc_content;
	}

	public String getTc_date() {
		return tc_date;
	}

	public void setTc_date(String tc_date) {
		this.tc_date = tc_date;
	}
}
