package com.ex.spring5;

public class Calculator {
	private int a;
	private int b;
	public void add(int a, int b) {
		this.a = a;
		this.b = b;
		System.out.println("a + b = " + (this.a+this.b));
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	public void dis() {
		System.out.println(this.a+ " " +this.b);
	}
}
