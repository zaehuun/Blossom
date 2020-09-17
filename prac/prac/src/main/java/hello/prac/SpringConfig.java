package hello.prac;

import hello.prac.Service.Service;
import hello.prac.repository.JpaRepository;
import hello.prac.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public Service memberService(){
        return new Service(memberRepository());
    }

    @Bean
    public Repository memberRepository() {
        //return new MemoryMemberRepository();
        return new JpaRepository(em);
    }
}