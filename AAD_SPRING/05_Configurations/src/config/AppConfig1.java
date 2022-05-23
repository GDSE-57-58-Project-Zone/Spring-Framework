package config;

import bean.A;
import bean.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Configuration
public class AppConfig1 {

    @Bean
    public A a(){
        return new A();
    }
    @Bean
    public B b(){
        return new B();
    }
}
