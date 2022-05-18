package bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Component
@Scope("prototype")
public class SpringBeanOne {
    public SpringBeanOne() {
        System.out.println("Spring Bean One");
    }
}
