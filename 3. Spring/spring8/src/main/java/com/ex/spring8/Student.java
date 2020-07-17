package com.ex.spring8;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Student {
	public String name;
	public int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println("aaaaaaaaaaaaaaaaaaa");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("bbbbbbbbbbbbbbbbbbb");
	}
}
