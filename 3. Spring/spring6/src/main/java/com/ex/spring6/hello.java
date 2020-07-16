package com.ex.spring6;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class hello {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		myInfo a = ctx.getBean("myInfo",myInfo.class);
		a.dis();
		// TODO Auto-generated method stub

	}

}
