package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//공연 기획자 느낌
//spring이 싱글톤 객체로 만들어서 관리 함
@Configuration
//configuration 없으면 아래 빈들은 스프링 컨테이너에서 관리 x 
public class AppConfig {
    //현재 memberService와 orderService 두 곳에서 memberRepository 호출하는데 싱글톤이 깨질까?
    //근데 테스트 코드 실행하면 다 같은 repository 인스턴스임

    @Bean
    //@Bean(name = "mm") 으로 변경 가능
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
