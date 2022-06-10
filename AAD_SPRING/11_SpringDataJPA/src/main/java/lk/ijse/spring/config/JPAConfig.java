package lk.ijse.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sql.DataSource;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Configuration
public class JPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter va){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setJpaVendorAdapter(va); // Vendor (Hibernate)
        bean.setDataSource(ds); //Connection
        bean.setPackagesToScan("lk.ijse.spring.entity"); // location of the entity
        return bean;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/springjpa?createDatabaseIfNotExist=true");
        dataSource.setUsername("root");
        dataSource.setPassword("sanu");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

}
