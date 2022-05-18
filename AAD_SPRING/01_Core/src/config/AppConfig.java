package config;

import bean.MyConnection;
import bean.SpringBeanOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

//Spring Bean definitions walata source ekak
//How to scan POJOs and enter to the Application Context
@Configuration
//@ComponentScan(basePackages = "bean")
@ComponentScan(basePackageClasses = SpringBeanOne.class)
public class AppConfig {
    public AppConfig() {
        System.out.println("App Config Object Created");
    }

    //when we are not allowed to put the @Component annotation we can use this method to
    //introduce a Spring bean to the Application Context
    @Bean("connection")
    public MyConnection getConnection() {
        return new MyConnection();
    }

}

