package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("customer")
public class CustomerController {

    @GetMapping
    public String getAllCustomer(){
        return "Hello There..!";
    }
}
