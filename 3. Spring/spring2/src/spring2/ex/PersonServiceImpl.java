package spring2.ex;

public class PersonServiceImpl implements PersonService {
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void say() {
		System.out.println("�̸�: " + name);
		System.out.println("����: " + age);
	}
}
