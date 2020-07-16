package com.ex.spring7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student student1 = ctx.getBean("student1",Student.class);
		student1.show();
		
		Student student2 = ctx.getBean("student2",Student.class);
		student2.show();
	}

}
