package spring4.ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("AOPTest.xml"); //AOPTest.xml을 읽어 들여 빈 생성
		Calculator cal = (Calculator)context.getBean("proxyCal"); //id가 proxyCal인 빈에 접근
		cal.add(100,20); //메소드 호출 전후에 어드바이스 빈이 적용
		System.out.println();
		cal.substract(100, 20);
		System.out.println();
	}

}
