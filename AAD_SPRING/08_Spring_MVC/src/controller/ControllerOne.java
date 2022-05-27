package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("controllerone")
public class ControllerOne {

    public ControllerOne() {
        System.out.println("Controller One Instantiated");
    }

    @GetMapping
    public void testMethod() {
        System.out.println("Request Received");
    }

}
