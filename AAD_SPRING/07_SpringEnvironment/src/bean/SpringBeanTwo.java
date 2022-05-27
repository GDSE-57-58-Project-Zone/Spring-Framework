package bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@Configuration
public class SpringBeanTwo implements InitializingBean {
    @Value("${my.name}")
    private String myName;
    @Value("${my.age}")
    private String myAge;

    public SpringBeanTwo() {
        System.out.println("Spring Bean Two Instantiated");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(myName);
        System.out.println(myAge);
    }
}
