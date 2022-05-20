import bean.Boy;
import bean.Girl;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        context.registerShutdownHook();


        Boy boy = context.getBean(Boy.class);
        boy.chattingWithGirl();
//        Girl girl = context.getBean(Girl.class);
//





    }
}
