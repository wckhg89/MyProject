package com.employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");

		EmployeeBean emp1 = (EmployeeBean) context.getBean("employee1");
		printInfo(emp1);
		System.out.println("--------------------");
		EmployeeBean emp2 = (EmployeeBean) context.getBean("employee2");
		printInfo(emp2);
		
	}

	private static void printInfo(EmployeeBean emp) {
		System.out.println("Info : " + emp.getClass().getSimpleName());
		System.out.println("ID : " + emp.getId());
		System.out.println("Name : " + emp.getName());

	}

}
