package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@Component
public class Boy implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

//    @Autowired
//    Girl girl; // property injection

    @Autowired
    GoodGirl girl;

    public Boy() {
        System.out.println("Boy Instantiated");
    }

    public void chattingWithGirl(){
        girl.chat();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Boy Bean Factory Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Boy Bean Name Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Boy Disposable Bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Boy Initializing Bean  Aware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Boy Application Context Aware");
    }
}
