package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("json")
public class JSONController {

    @PostMapping// if you want to get json request content you have to use @RequestBody
    public String getJsonRequest(@RequestBody CustomerDTO dto) {
        return "Hello JSON " + dto.toString();
    }

    // to return json response you need json converter in the classpath
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})//content-type=application/json
    public CustomerDTO sendBackJSON() {
        return new CustomerDTO("C001", "Dasun", "Galle", 100.00);
    }

    @GetMapping(path = "array", produces = {MediaType.APPLICATION_JSON_VALUE})//content-type=application/json
    public ArrayList<CustomerDTO> sendBackJSONArray() {
        ArrayList<CustomerDTO> all = new ArrayList<>();
        all.add(new CustomerDTO("C001", "Ramal", "Galle", 1200.00));
        all.add(new CustomerDTO("C002", "Ravindu", "Panadura", 3100.00));
        all.add(new CustomerDTO("C003", "Kamal", "Kaluthara", 1400.00));
        return all;
    }


}
