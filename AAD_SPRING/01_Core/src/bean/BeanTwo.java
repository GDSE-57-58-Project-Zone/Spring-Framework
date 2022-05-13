package bean;

import org.springframework.stereotype.Component;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Component
public class BeanTwo {
    public BeanTwo() {
        System.out.println("Object created from bean two");
    }
}
