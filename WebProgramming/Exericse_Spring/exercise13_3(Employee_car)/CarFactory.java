package com.caremp;

public class CarFactory {
	
	public static CarBean makeCar(){
		return makeCar();
	}
	
	public static CarBean makeCar(String model, int year){
		return new CarBean(model,year);
	}
	
	public static CarBean makeCar(String model, int year, String maker){
		return new CarBean(model,year,maker);
	}
	
}
//car list 모델이랑 년도있는거 받아서 팩토리 클래스안에서 모델이랑 연도 통해서 임플로이 생성