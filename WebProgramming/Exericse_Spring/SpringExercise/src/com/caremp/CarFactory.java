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
//car list ���̶� �⵵�ִ°� �޾Ƽ� ���丮 Ŭ�����ȿ��� ���̶� ���� ���ؼ� ���÷��� ����