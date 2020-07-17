package com.ex.spring8;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ctx.load("classpath:applicationCTX.xml");
		ctx.refresh();
		
		Student student = ctx.getBean("student",Student.class);
		System.out.println("name : " + student.name);
		System.out.println("age : " + student.age);
		
		ctx.close();
	}

}
