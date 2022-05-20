import bean.Boy;
import config.AppConfig;
import di.Kamal;
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


//        Kamal kamal = context.getBean(Kamal.class);
//        kamal.chattingWithKamali();





    }
}
