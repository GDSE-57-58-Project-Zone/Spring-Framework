package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RequestMapping("api/v1/customer")
@RestController
@CrossOrigin
public class CustomerController {

    @GetMapping
    public ArrayList<CustomerDTO> getAllCustomers(){
        ArrayList<CustomerDTO> arrayList= new ArrayList<>();
        arrayList.add(new CustomerDTO("C001","Dasun","Galle",1000));
        arrayList.add(new CustomerDTO("C002","Kasun","Galle",1000));
        arrayList.add(new CustomerDTO("C003","Dananjaya","Galle",1000));
        return arrayList;
    }
}
