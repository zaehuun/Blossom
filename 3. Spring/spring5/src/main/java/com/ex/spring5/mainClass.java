package com.ex.spring5;

import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			String path = "classpath:applicationCTX.xml";
			AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
			Calculator cal = ctx.getBean("calc",Calculator.class);
			cal.dis();
	}

}
