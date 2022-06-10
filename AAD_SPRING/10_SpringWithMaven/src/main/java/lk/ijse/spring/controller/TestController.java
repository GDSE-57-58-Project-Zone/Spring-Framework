package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("test")
public class TestController {

    // we can narrow down request using headers also

    /*//consumes -> application/json (request body should include content-type=application/json header)
    @GetMapping(consumes = "application/json")
    public CustomerDTO searchCustomer() {
        return new CustomerDTO("C002","GDSE","Panadura",1000);
    }

    // produce -> response type json
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO getAllCustomers() {
        return new CustomerDTO("C001","IJSE","Panadura",1000);
    }*/



    //consumes =  if we put consumes type that means you have to put content type header
    //in the request

    //produce = if you want to state that what your are going to produce from here
    //you can use produced header
    // also put the accept header in the request header
    @GetMapping(consumes = "text/html",produces = "application/json")
    public CustomerDTO testMethodOne(){
        return new CustomerDTO("C001","Text","Panadura",1000);
    }

    @GetMapping(consumes = "application/json",produces = "application/json")
    public CustomerDTO testMethodTwo(){
        return new CustomerDTO("C002","JSON","Panadura",1000);
    }

    @GetMapping(headers = {"Content-Type=text/css","Accept=application/json"})
    public CustomerDTO testMethodThree(){
        return new CustomerDTO("C003","JSON","Panadura",1000);
    }








}
