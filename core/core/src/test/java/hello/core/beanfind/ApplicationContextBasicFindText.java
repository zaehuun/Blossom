package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class ApplicationContextBasicFindText {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //System.out.println("memberService = " + memberService);
        //System.out.println("memberService.getClass() = " + memberService.getClass());

        //인터페이스를 조회하면 인터페이스의 구현체가 대상이 됨
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }



    /*
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        //같은 타입이 여러 개면 좀 곤란
        MemberService memberService = ac.getBean(MemberService.class);
        //System.out.println("memberService = " + memberService);
        //System.out.println("memberService.getClass() = " + memberService.getClass());

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    */
    @Test
    @DisplayName("구체 타입으로만 조회")
    void findBeanByName2() {

        //같은 타입이 여러 개면 좀 곤란
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        //System.out.println("memberService = " + memberService);
        //System.out.println("memberService.getClass() = " + memberService.getClass());

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회x")
    void findBeanByNameX(){

        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));
        //아래 getBean을 실행하면 NoSuchBean이 떠야함
        //터져야 성공
    }
}
