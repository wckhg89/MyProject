package com.caremp;

public class CarBean {
	private String model;
	private int year;
	private String maker;
	
	public CarBean() {
		// TODO Auto-generated constructor stub
	}
	public CarBean(String model, int year) {
		super();
		this.model = model;
		this.year = year;
		if(this.model.equals("Aslan")){
			this.maker = "Hyundae";
		}else{
			this.maker = "KIA";
		}
	}
	
	public CarBean(String model, int year, String maker) {
		super();
		this.model = model;
		this.year = year;
		this.maker = maker;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}

}
