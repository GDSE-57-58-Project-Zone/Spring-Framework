package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@Configuration
@ComponentScan(basePackages = {"controller"})
@EnableWebMvc
public class WebAppConfig implements WebMvcConfigurer {

    // /views/index.html
    //  /views/customer.html
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver v= new InternalResourceViewResolver();
        v.setPrefix("/views/");
        v.setSuffix(".html");
        v.setOrder(2);
        return v;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/views/**").addResourceLocations("/views/");
    }
}
