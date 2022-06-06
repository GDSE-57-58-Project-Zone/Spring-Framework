package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("form")
public class FormDataController {

    // x-www-form-url-encoded
    //query String


    @PostMapping
    public String testForm1(@ModelAttribute CustomerDTO dto) {
        return "Request Received " + dto.toString();
    }


}
