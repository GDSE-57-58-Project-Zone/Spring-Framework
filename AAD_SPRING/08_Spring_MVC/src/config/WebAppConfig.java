package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@Configuration
@ComponentScan(basePackages = "bean")
@EnableWebMvc
public class WebAppConfig {
}
