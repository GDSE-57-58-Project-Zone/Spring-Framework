package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SpringBeanOne implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public SpringBeanOne() {
        System.out.println("Spring Bean One Instantiated");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name Aware Called");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Bean Factory Aware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application Context Aware Called");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean Called and Bean is ready to use");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Spring Bean One Destroyed");
    }
}
