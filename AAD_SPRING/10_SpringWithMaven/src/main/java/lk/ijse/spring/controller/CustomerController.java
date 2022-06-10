package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RequestMapping("api/v1/customer")
public class CustomerController {

    @GetMapping
    public ArrayList<CustomerDTO> getAllCustomers(){
        ArrayList<CustomerDTO> arrayList= new ArrayList<>();
        return arrayList;
    }
}
