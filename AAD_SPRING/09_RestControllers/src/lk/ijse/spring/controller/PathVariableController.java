package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("variable")
public class PathVariableController {

    //http://localhost:8080/restcontroller/variable/GDSE
    //(variable) path segments
    //(I001) path segments

    // In spring we can retrieve values of path segments
    // To do that we have to crate path variables -> {I001}

    @GetMapping(path = "{id}")
    public String test(@PathVariable String id) {
        return id;
    }

    @GetMapping(path = "{customerID}/{customerName}") //  setting alias when parameters names and variable names differ
    public String test2(@PathVariable("customerID") String id,@PathVariable("customerName") String name) {
        return id +" "+name;
    }
}
