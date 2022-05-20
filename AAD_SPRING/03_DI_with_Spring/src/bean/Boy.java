package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@Component
public class Boy {

    @Autowired
    Girl girl;

    public Boy() {
        System.out.println("Boy Instantiated");
    }

    public void chattingWithGirl(){
        System.out.println("from boy"+this.girl);
        girl.chat();
    }
}
