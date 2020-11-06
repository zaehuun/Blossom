package hello.core.singleton;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {


    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean((StatefulService.class));
        StatefulService statefulService2 = ac.getBean((StatefulService.class));
        /*//상태 유지 할 때의 테스트 코드
        //ThreadA: A사용자가 10000원 주문
        statefulService1.order("userA", 10000);

        //ThreadB: B사용자가 20000원 주문
        statefulService2.order("userB", 20000);

        //ThreadA: 사용자A가 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price); //중간에 사용자 B가 값을 바꿔서 10000 아닌 20000원 출력
        */


        //상태 유지 안 할 때의 테스트코드
        int userAPrice = statefulService1.order("userA", 10000);
        int userBPrice = statefulService2.order("userB", 20000);
        //org.assertj.core.api.Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
