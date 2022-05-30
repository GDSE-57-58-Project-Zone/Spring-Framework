package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Controller
@RequestMapping("controllerone")
public class ControllerOne {

    @GetMapping
    public void testMethod() {
        System.out.println("Request Received");
    }

}
