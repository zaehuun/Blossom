package hello.core.singleton;

public class StatefulService {
    /*상태를 유지하는 필드 상태
    private int price;

    public void order(String name, int price){
        System.out.println("name = " + name + ", price = " + price);
        this.price = price; //여기가 문제!
    }

    public int getPrice(){
        return price;
    }
    */

    //상태 유지 안 하는 상태
    public int order(String name, int price){
        System.out.println("name = " + name + ", price = " + price);
        return price;
    }

}
