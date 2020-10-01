package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    //return 할인 대상 금액
    //얼만큼 할인이 됐는지
    int discount(Member member, int price);
}
