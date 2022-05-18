package bean;

import org.springframework.stereotype.Component;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Component
public class SpringBeanOne {
    public SpringBeanOne() {
        System.out.println("Spring Bean One");
    }
}
