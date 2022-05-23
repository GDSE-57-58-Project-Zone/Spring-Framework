package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

//A source for Spring Bean Definitions
@Configuration
@ComponentScan(basePackages = "bean")
@Import({AppConfig1.class,AppConfig2.class})// we can import configurations into a single class
//@ImportResource("classpath:abcd.xml") // we can use this annotation to import xml configurations to the context
//@ImportResource("file:absolute-path-of-abcd.xml")
public class AppConfig {

}
