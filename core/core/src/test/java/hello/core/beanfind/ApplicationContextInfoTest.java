package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        //iter + tab
        for (String beanDefinitionName : beanDefinitionNames) {
            //오브젝트가 꺼내짐
            //스프링 자체가 만든 빈들도 나옴
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        //iter + tab
        for (String beanDefinitionName : beanDefinitionNames) {
  
            //ROLE ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //ROLE ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
            }

        }
    }

}
