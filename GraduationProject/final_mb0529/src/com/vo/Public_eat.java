package com.vo;

public class Public_eat {

	String tmp_food_id;
	String name;
	String textarea;
	String category_id;
	int  area_code;
	int sigungu_code;
	double coordinates;

	/**
	 * 
	 * @param tmp_eat_id
	 * @param name
	 * @param category_id
	 * @param area_code
	 * @param sigungu_code
	 * @param coordinates
	 */
	public Public_eat(String tmp_eat_id, String name, String category_id,
			int area_code, int sigungu_code, double coordinates) {
		super();
		this.tmp_food_id = tmp_eat_id;
		this.name = name;
		this.category_id = category_id;
		this.area_code = area_code;
		this.sigungu_code = sigungu_code;
		this.coordinates = coordinates;
	}

	public String getTmp_eat_id() {
		return tmp_food_id;
	}
	public void setTmp_eat_id(String tmp_food_id) {
		this.tmp_food_id = tmp_food_id;
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

	public String getTmp_food_id() {
		return tmp_food_id;
	}

	public void setTmp_food_id(String tmp_food_id) {
		this.tmp_food_id = tmp_food_id;
	}

	public String getTextarea() {
		return textarea;
	}

	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}
}
