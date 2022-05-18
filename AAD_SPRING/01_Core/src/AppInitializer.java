import bean.MyConnection;
import bean.SpringBeanThree;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class AppInitializer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        //Run something just before jvm shutdown
        //Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        //   @Override
        //  public void run() {
        //     System.out.println("JVM is about to Shut Down");
        //        ctx.close();
        //    }
        //}));

        ctx.registerShutdownHook();
        ctx.register(AppConfig.class);
        ctx.refresh();

        //SpringBeanOne beanOne = ctx.getBean(SpringBeanOne.class);
        //SpringBeanTwo beanTwo = ctx.getBean(SpringBeanTwo.class); // class type
        //System.out.println(beanOne);
        //System.out.println(beanTwo);
        //
//        SpringBeanThree beanThree = ctx.getBean(SpringBeanThree.class);
//        System.out.println(beanThree);

        //Request Beans from Application Context using bean Id
        //Bean Name request (Bean ID)
        //SpringBeanOne->  springBeanOne (Bean ID) // how the default bean id is generated
        //SpringBeanOne springBeanOne = (SpringBeanOne) ctx.getBean("springBeanOne");
        //System.out.println(springBeanOne);

        //SpringBeanTwo -> springBeanTwo
        //SpringBeanTwo springBeanTwo = (SpringBeanTwo) ctx.getBean("springBeanTwo");//bean id
        //System.out.println(springBeanTwo);

        //SpringBeanThree -> springBeanThree
        // we can change the default bean id to what we want
//        SpringBeanThree springBeanThree = (SpringBeanThree) ctx.getBean("BeanThree");
//        System.out.println(springBeanThree);


        MyConnection bean = ctx.getBean(MyConnection.class);
        System.out.println(bean);

    }
}
