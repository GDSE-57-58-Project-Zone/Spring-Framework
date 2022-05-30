package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Controller
@RequestMapping("customer") // Handler method
public class ControllerTwo {

    //Mapping methods // Handler Methods
    @GetMapping
    public String testTwo() {
        return "customer";
    }

}
