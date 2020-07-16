package com.ex.spring6;

import java.util.ArrayList;

public class myInfo {
	public String name;
	public int age;
	public ArrayList<String> hobby;
	public Calculator calc;
	
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
	public ArrayList<String> getHobby() {
		return hobby;
	}
	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}
	public Calculator getCalc() {
		return calc;
	}
	public void setCalc(Calculator calc) {
		this.calc = calc;
	}
	public void dis() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("hobby : " + hobby);
		System.out.println("calc : " + calc.first + calc.second);
	}
	
}
