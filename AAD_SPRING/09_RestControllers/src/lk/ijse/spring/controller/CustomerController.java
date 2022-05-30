package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
//REST = Representational State Transfer (A way of data transfer among client server apps)
@RestController
@RequestMapping("customer") //handler mapping
public class CustomerController {

    @GetMapping//handler mapping
    public String getAllCustomer(){ // handler methods
        return "Get All Customers Invoked and Get Method Invoked";
    }

    @GetMapping(path = "search") //handler mapping
    public String searchCustomer(){ // handler methods
        return "Search Customers Invoked and Get Method Invoked";
    }

    @GetMapping(path = "newid") //handler mapping
    public String generateNewID(){ // handler methods
        return "New Customers ID Invoked and Get Method Invoked";
    }

    @PostMapping  //handler mapping
    public String saveCustomer(){ // handler methods
        return "Customer Saved and Post Method Invoked";
    }

    @DeleteMapping //handler mapping
    public String deleteCustomer(){ // handler methods
        return "Customer Deleted and Delete Method Invoked";
    }

    @PutMapping //handler mapping
    public String updateCustomer(){// handler methods
        return "Customer Updated and Put Method Invoked";
    }
}
