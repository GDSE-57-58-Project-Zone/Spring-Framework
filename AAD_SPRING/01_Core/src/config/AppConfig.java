package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

//Bean definitions walata source ekak
// How to scan pojos and enter to the Application Context
@Configuration
@ComponentScan(basePackages = "bean")
public class AppConfig {
    public AppConfig() {
        System.out.println("App Config Object Created");
    }
}

