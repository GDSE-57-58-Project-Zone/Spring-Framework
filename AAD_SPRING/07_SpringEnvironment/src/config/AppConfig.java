package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Configuration
@ComponentScan(basePackages = "bean")
@PropertySource("classpath:application.properties")
@PropertySource("classpath:configuration.properties")
public class AppConfig {
}
