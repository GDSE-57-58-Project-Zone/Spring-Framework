package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class SpringBeanOne implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public SpringBeanOne() {
        System.out.println("Spring Bean One Instantiated");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Spring Bean One Bean Factory Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Spring Bean One Bean Name Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Spring Bean One Disposable Bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Spring Bean One Initializing Bean  Aware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Spring Bean One Application Context Aware");
    }
}
