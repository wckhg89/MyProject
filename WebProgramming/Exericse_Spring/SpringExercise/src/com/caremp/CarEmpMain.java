package com.caremp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CarEmpMain {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");
		
		for(int i=1 ; i<=4 ; i++){
			EmployeeBean emp = (EmployeeBean)context.getBean("employeec"+i);
			emp.EmpInfo();
		}
	}
}
