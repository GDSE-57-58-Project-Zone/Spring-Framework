import bean.SpringBean;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class AppInitializer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();

        ctx.register(AppConfig.class);

        ctx.refresh();


//        SpringBean bean = ctx.getBean(SpringBean.class);
//        bean.testBean();
//        System.out.println(bean);


        ctx.close();



    }
}
