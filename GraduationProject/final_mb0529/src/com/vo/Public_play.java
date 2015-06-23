package com.vo;

public class Public_play {
	String tmp_play_id;
	String name;
	String textarea;
	String category_id;
	int  area_code;
	int sigungu_code;
	double coordinates;
	/**
	 * 
	 * @param tmp_play_id
	 * @param name
	 * @param textarea
	 * @param category_id
	 * @param area_code
	 * @param sigungu_code
	 * @param coordinates
	 */
	public Public_play(String tmp_play_id, String name, String textarea , String category_id,
			int area_code, int sigungu_code, double coordinates) {
		super();
		this.tmp_play_id = tmp_play_id;
		this.name = name;
		this.textarea = textarea;
		this.category_id = category_id;
		this.area_code = area_code;
		this.sigungu_code = sigungu_code;
		this.coordinates = coordinates;
	}
	
	public Public_play(String name , String textarea){
		super();
		this.name = name;
		this.textarea = textarea;
	}
	public String getTmp_play_id() {
		return tmp_play_id;
	}
	public void setTmp_play_id(String tmp_play_id) {
		this.tmp_play_id = tmp_play_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public int getArea_code() {
		return area_code;
	}
	public void setArea_code(int area_code) {
		this.area_code = area_code;
	}
	public int getSigungu_code() {
		return sigungu_code;
	}
	public void setSigungu_code(int sigungu_code) {
		this.sigungu_code = sigungu_code;
	}
	public double getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(double coordinates) {
		this.coordinates = coordinates;
	}

	public String getTextarea() {
		return textarea;
	}

	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}
}
