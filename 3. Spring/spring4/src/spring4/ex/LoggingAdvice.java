package spring4.ex;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{
	public Object invoke(MethodInvocation invocation) throws Throwable{
		System.out.println("�޼ҵ� ȣ�� �� : LoggingAdvice");
		System.out.println(invocation.getMethod() + "�޼ҵ� ȣ�� ��");
		
		Object object = invocation.proceed();
		
		System.out.println("�޼ҵ� ȣ�� �� : loggingAdvice");
		System.out.println(invocation.getMethod() + "�޼ҵ� ȣ�� ��");
		return object;
	}
}
