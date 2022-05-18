package bean;

import org.springframework.stereotype.Component;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Component("BeanThree")
public class SpringBeanThree {
    public SpringBeanThree() {
        System.out.println("Spring Bean Three");
    }
}
