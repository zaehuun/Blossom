package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //basePackages = "hello.core.member" 이 부분만 스캔
        //지정하지 않으면 AutoAppConfig가 있는 패키지 Apphello.core 하위 클래스 다 뒤짐
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //configuration도 자동으로 하면 우리가 수동으로 등록할 때 충돌나서 제외시킴
)
public class AutoAppConfig {
}
