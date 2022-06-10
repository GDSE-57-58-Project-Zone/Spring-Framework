package lk.ijse.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Configuration
public class JPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setJpaVendorAdapter(); // Vendor
        bean.setDataSource(); //Connection
        bean.setPackagesToScan("lk.ijse.spring.entity"); // location of the entity
        return bean;
    }
}
