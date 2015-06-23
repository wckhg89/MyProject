package com.caremp;

import java.util.List;

public class EmployeeBean {
	private int id;
	private String name;
	private List<CarBean> cars;

	public EmployeeBean() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeBean(int id, String name, List<CarBean> cars) {
		super();
		this.id = id;
		this.name = name;
		this.cars = cars;
	}

	public List<CarBean> getCars() {
		return cars;
	}

	public void setCars(List<CarBean> cars) {
		this.cars = cars;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void EmpInfo() {
		System.out.println("ID : " + this.id);
		System.out.println("NAME : " + this.name);
		for (int i = 0; i < cars.size(); i++) {
			System.out.println("Model" + this.cars.get(i).getModel());
			System.out.println("Year" + this.cars.get(i).getYear());
			System.out.println("Maker" + this.cars.get(i).getMaker());
		}
	}

}
