package com.ex.spring7;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("sleep");
		hobbys.add("eat");
		
		Student student = new Student("È«±æµ¿",18,hobbys); //construct
		student.setWeight(100.0);
		student.setHeight(100.0); //property
		
		return student;
	}
	
	@Bean
	public Student student2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("soccer");
		hobbys.add("run");
		
		Student student = new Student("È«±æ¼ø",19,hobbys); //construct
		student.setWeight(105.0);
		student.setHeight(105.0); //property
		
		return student;
	}
}
