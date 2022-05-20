package config;

import bean.SpringBeanOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Configuration
@ComponentScan(basePackages = "bean")
public class AppConfig {


}
