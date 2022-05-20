import bean.SpringBeanOne;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        ctx.registerShutdownHook();


        SpringBeanOne bean1 = ctx.getBean(SpringBeanOne.class);
        SpringBeanOne bean2 = ctx.getBean(SpringBeanOne.class);
        System.out.println(bean1);
        System.out.println(bean2);

    }
}
