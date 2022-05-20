package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Component
public class SpringBeanTwo implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public SpringBeanTwo() {
        System.out.println("Spring Bean Two Instantiated");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Spring Bean Two Bean Factory Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Spring Bean Two Bean Name Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Spring Bean Two Bean Destory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Spring Bean Two Bean Initializing Bean");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Spring Bean Two Bean Application Context Aware");
    }
}
