package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class MyConnection implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public MyConnection() {
        System.out.println("MyConnection Instantiated");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("MyConnection Bean Factory Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("MyConnection Bean Name Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyConnection Disposable Bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyConnection Initializing Bean");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("MyConnection Application Context Aware");
    }
}
