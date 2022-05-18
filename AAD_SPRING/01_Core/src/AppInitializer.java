import bean.SpringBeanOne;
import bean.SpringBeanThree;
import bean.SpringBeanTwo;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class AppInitializer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

//        //Run something just before jvm shutdown
//        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("JVM is about to Shut Down");
//                ctx.close();
//            }
//        }));

        ctx.registerShutdownHook();


        ctx.register(AppConfig.class);
        ctx.refresh();


        SpringBeanOne beanOne = ctx.getBean(SpringBeanOne.class);
        SpringBeanTwo beanTwo = ctx.getBean(SpringBeanTwo.class);
        System.out.println(beanOne);
        System.out.println(beanTwo);

        SpringBeanThree beanThree = ctx.getBean(SpringBeanThree.class);
        System.out.println(beanThree);







    }
}
