package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public void saveCustomer(@ModelAttribute CustomerDTO customer) {
        customerService.saveCustomer(customer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody CustomerDTO customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping(params = {"id"})
    public void deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping(path = "/{id}")
    public CustomerDTO searchCustomer(@PathVariable String id) {
        return customerService.searchCustomer(id);
    }


}
