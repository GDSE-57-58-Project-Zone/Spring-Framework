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

    //http://localhost:8080/restcontroller/variable/I001

    @GetMapping(path = "{I001}")
    public String test(@PathVariable("I001") String itemCode) {
        return itemCode;
    }
}
