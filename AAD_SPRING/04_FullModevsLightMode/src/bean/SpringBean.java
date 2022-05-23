package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Component
public class SpringBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public SpringBean() {
        System.out.println("Spring Bean Instantiated");
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Spring Bean Bean Factory Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Spring Bean Bean Name Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Spring Bean Disposable Bean Aware");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Spring Bean Initializing Bean");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Spring Bean Application Context Aware");
    }

//    //Light Mode
    @Bean
    public MyBasicDataSource basicDataSource() {

        //inter-bean dependency invocation
        MyConnection myConnection1 = myConnection(); //not satisfying dependency // new object // not manage by application context
        MyConnection myConnection2 = myConnection(); //not satisfying dependency // new object // not manage by application context
        MyConnection myConnection3 = myConnection(); //not satisfying dependency// new object // not manage by application context

        System.out.println(myConnection1);
        System.out.println(myConnection2);
        System.out.println(myConnection3);

        MyBasicDataSource myBasicDataSource = new MyBasicDataSource();
        myBasicDataSource.setMyConnection(myConnection1);

        return myBasicDataSource;
    }

    @Bean
    public MyConnection myConnection() {
        return new MyConnection();
    }

}
