package spring3.ex;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml")); //실행 시 person.xml을 읽어 들여 빈 생성
		PersonService person = (PersonService) factory.getBean("personService"); //id가 personService인 빈 가져옴
		PersonService person1 = (PersonService) factory.getBean("personService1");
		person.say();
		person1.say();
	}

}
