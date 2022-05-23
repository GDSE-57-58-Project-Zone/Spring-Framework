package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

//A source for Spring Bean Definitions
@Configuration
@ComponentScan(basePackages = "bean")
public class AppConfig {

}
