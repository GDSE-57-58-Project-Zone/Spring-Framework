import config.AppConfig;
import config.AppConfig1;
import config.AppConfig2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.register(AppConfig1.class);
        context.register(AppConfig2.class);

        context.refresh();
        context.registerShutdownHook();
    }
}
