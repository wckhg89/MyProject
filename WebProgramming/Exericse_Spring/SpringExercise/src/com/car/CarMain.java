package com.car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CarMain {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");
		
		for(int i=1 ; i<=4 ; i++){
			CarBean car = (CarBean)context.getBean("car"+i);
			CarInfo(car);
		}
	}
	private static void CarInfo(CarBean car){
		System.out.println("Model : " +  car.getModel());
		System.out.println("Year  : " +  car.getYear());
		System.out.println("Maker : " +  car.getMaker());
	}
}
