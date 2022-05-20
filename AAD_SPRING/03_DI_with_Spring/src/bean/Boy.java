package bean;

import org.springframework.stereotype.Component;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@Component
public class Boy {
    public Boy() {
        System.out.println("Boy Instantiated");
    }

    public void chattingWithGirl(){
        Girl girl = new Girl();
        girl.chat();
    }
}
