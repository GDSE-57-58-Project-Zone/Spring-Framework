package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("json")
public class JSONController {

    @PostMapping
    public String getJsonRequest(CustomerDTO dto) {
        return "Hello JSON " + dto.toString();
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})//content-type=application/json
    public CustomerDTO sendBackJSON() {
        return new CustomerDTO("C001","Dasun","Galle",100.00);
    }

}
