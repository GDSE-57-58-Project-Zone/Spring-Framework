package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Component
@Primary
public class GirlOne implements GoodGirl,BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean  {

    public GirlOne() {
        System.out.println("Girl One Instantiated");
    }

    @Override
    public void chat() {
        System.out.println("Girl One is Chatting");
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Girl One Bean Factory Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Girl One Bean Name Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Girl One Disposable Bean Aware");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Girl One Initializing Bean Aware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Girl One Application Context");
    }
}
