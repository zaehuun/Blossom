package spring4.ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("AOPTest.xml"); //AOPTest.xml�� �о� �鿩 �� ����
		Calculator cal = (Calculator)context.getBean("proxyCal"); //id�� proxyCal�� �� ����
		cal.add(100,20); //�޼ҵ� ȣ�� ���Ŀ� �����̽� ���� ����
		System.out.println();
		cal.substract(100, 20);
		System.out.println();
	}

}
