package com.vo;

public class SocialReviewList {
	private String s_id;
	private int srv_num;
	private String srv_img;
	
	public SocialReviewList() {
	}

	public SocialReviewList(String s_id, int srv_num, String srv_img) {
		this.s_id = s_id;
		this.srv_num = srv_num;
		this.srv_img = srv_img;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public int getSrv_num() {
		return srv_num;
	}

	public void setSrv_num(int srv_num) {
		this.srv_num = srv_num;
	}

	public String getSrv_img() {
		return srv_img;
	}

	public void setSrv_img(String srv_img) {
		this.srv_img = srv_img;
	}
	
		
	
}
