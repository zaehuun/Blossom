# **Spring**

## **1. 프레임 워크**

* 사전적 의미는 '아떤 것을 구성하는 구조 또는 뼈대'  
* 웹 어플리케이션에서 필요한 공통 기능들을 처음부터 다 개발하는 것은 비효율적이기에 많이 사용하는 기능은 미리 만들어서 제공하고, 그 외에 필요한 부분만 추가 및 수정하게 함.   
* 즉, 어느 정도 완성된 상태로 기능들이 제공되고 디테일한 부분만 따로 개발을 하면 된다.   
* 일정 기준에 따라 개발이 되기에 개발 생산성과 품질이 보장된 어플리케이션 개발 할 수 있게 된다.   
**※라이브러리와의 차이 알아보기!**   
   
## **2. 스프링 프레임 워크의 특징**

* 가볍고 배우기 쉬운(?) 경량 컨테이너   
* **의존성 주입(DI)** 기능 지원   
* **제어 역행(IoC)** 기술을 이용해 어플리케이션 간 느슨한 결합 제어   
* **관점 지향(AOP)** 을 이용해 자원 관리   
* 영속성과 관련된 다양한 서비스 지원   
* 다양한 라이브러리와의 연동 기능
※강조된 단어들은 추가적으로 자세히 알아볼 예정   
   

   
## **의존성 주입**

### **의존이란?**
-어떤 클래스의 처리 내용이 다른 클래스의 내용이 변경됨에 따라 달라지는 관계를 말합니다.  
-의존성이 높은 것은 일체형 배터리, 낮은 것은 분리형 배터리 (배터리 교체 시, 일체형은 핸드폰을 다 뜯어 고쳐야 하지만 분리형은 배터리 빼서 교체하면 됨.)    
```
public class A {

    B b = new B();
    
    public void methodA() {
    	b.methodB();
    }
}
```
A 클래스에서는 B 클래스에 정의되어 있는 메서드를 사용하기 위해 B의 객체를 생성한 다음에 메서드를 호출하고 있다. 이때 A 클래스가 B 클래스의 메서드를 실행하고 있는 상태인데 이것을 을 **A가 B에 의존한다고 표현**한다. 이런 의존 관계에서 methodB 메서드의 내용이 달라지면 A의 내용도 달라지게 된다.   
이런 경우 **유지 보수**가 복잡해진다.   

이를 위해   
```
public class A {
    
    B b;
    
    public A(B b) {
    	this.b = b; //외부에서 만든 B 객체를 전달 받음
    }
    
    public void methodA() {
    	b.method();
    }
}
```
다음과 같이 B 객체를 직접 생성하지 않고, 외부에서 만든 B 객체를 전달하여 사용하는 방식을 **의존성 주입**이라고 한다. 말 그대로 의존성을 주입하는 것이다.   
   
```
public static void main(String args[]) {

    B b = new C(); // 수정된 부분
    A a = new A(b);
    Another aa = new Another(b);
    Other aaa = new Ohter(b);
}
```
따라서 B 객체말고 C 객체를 사용하고 싶어진다면 코드 전체를 돌면서 수정 할 필요 없이 변수 b에 들어갈 객체를 C로만 바꾸어 주면 변경이 끝난다.   
**의존성을 낮춤으로써 유지 보수를 간결하게 만들어준다.**
***
## **spring2 내용**
**setter**를 이용한 의존성 주입   
```
public class PersonServiceImpl implements PersonService {
	private String name;
	private int age;
	public void setName(String name) { //setter
		this.name = name;
	}
	@Override
	public void say() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
}
```
위치럼 setName이라는 setter 함수를 만들어 놓고 person.xml이라는 xml 파일에서 아래와 같이 입력한다.   
![image](https://user-images.githubusercontent.com/51132077/85930935-3e50b480-b8fb-11ea-8343-64d22abfc9c3.png)      
그럼 setter를 이용해 xml 파일에서 <value> 태그로 설정한 값을 name 속성에 주입하게 된다. age 속성은 setter가 없으므로 빈이 생성되더라도 값이 초기화 되지 않는다.   
**※setter 함수의 이름은 이유는 모르겠으나 꼭 set + 속성이름이어야 한다. 왠지 알아봐야겠다.**   
***
## **spring3 내용**
**생성자**를 이용한 의존성 주입
```
	public class PersonServiceImpl implements PersonService {
	private String name;
	private int age;
	
	public PersonServiceImpl(String name) {
		this.name = name;
	}
	
	public PersonServiceImpl(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public void say() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
}
```
spring2와는 다르게 생성자를 이용하여 의존성을 주입하는 예제이다. 생성자를 사용하는 만큼 xml 파일도 아래와 같이 수정한다.   
![image](https://user-images.githubusercontent.com/51132077/85931072-6391f280-b8fc-11ea-8e95-35016738cc03.png)  
첫 번째 빈은 인자가 한 개인 생성자를 이용하여 name 속성에 <value> 태그의 값이 주입되고, 두 번째 빈은 인자가 두 개인 생성자를 이용하여 name과 age 속성을 초기화 시킨다.   
***
## **spring4 내용**
**AOP : 관점 지향 프로그래밍** (한국말로 번역을 해서 그런가 뭔가 뜻이 어색하다.)   
**https://jojoldu.tistory.com/71**   
진짜 여기만한 곳이 없다
