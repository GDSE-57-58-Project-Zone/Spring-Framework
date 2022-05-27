package bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Component
public class SpringBeanOne implements InitializingBean {

    @Value("${user.name}")
    private String osName;

    public SpringBeanOne() {
        System.out.println("Spring Bean One Instantiated");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(osName);
    }
}
