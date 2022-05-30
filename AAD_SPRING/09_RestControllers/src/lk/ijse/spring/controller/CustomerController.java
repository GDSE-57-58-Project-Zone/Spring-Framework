package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
//REST = Representational State Transfer (A way of data transfer among client server apps)
@RestController
@RequestMapping("customer")
public class CustomerController {

    @GetMapping
    public String getAllCustomer(){
        return "Hello There..!";
    }

    @PostMapping
    public String saveCustomer(){
        return "Customer Saved and Post Method Invoked";
    }
}
