package spring3.ex;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml")); //���� �� person.xml�� �о� �鿩 �� ����
		PersonService person = (PersonService) factory.getBean("personService"); //id�� personService�� �� ������
		PersonService person1 = (PersonService) factory.getBean("personService1");
		person.say();
		person1.say();
	}

}
