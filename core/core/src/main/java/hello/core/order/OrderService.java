package hello.core.order;

public interface OrderService {
    //주문 생성 부분
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
