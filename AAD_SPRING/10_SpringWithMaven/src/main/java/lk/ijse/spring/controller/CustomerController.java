package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public ArrayList<CustomerDTO> getAllCustomers() {
        ArrayList<CustomerDTO> arrayList = new ArrayList<>();
        arrayList.add(new CustomerDTO("C001", "Dasun", "Galle", 1000));
        arrayList.add(new CustomerDTO("C002", "Kasun", "Galle", 1000));
        arrayList.add(new CustomerDTO("C003", "Dananjaya", "Galle", 1000));
        return arrayList;
    }

    @GetMapping(path = "/{id}")
    public CustomerDTO searchCustomer(@PathVariable String id) {
        return new CustomerDTO(id, "Dausn", "Galle", 1000);
    }


    @PutMapping(consumes ={MediaType.APPLICATION_JSON_VALUE} )
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO dto) {
        System.out.println(dto.toString());
        return dto;
    }


    @PostMapping(consumes = {"application/x-www-form-urlencoded"})
    public CustomerDTO saveCustomer(@ModelAttribute CustomerDTO dto) {
        System.out.println(dto.toString());
        return dto;
    }


}
