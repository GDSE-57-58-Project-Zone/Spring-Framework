package lk.ijse.spring.service;

import lk.ijse.spring.entity.Customer;

import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface CustomerService {
    void saveCustomer(Customer entity);
    void deleteCustomer(String id);
    void updateCustomer(Customer entity);
    Customer searchCustomer(String id);
    List<Customer> getAllCustomers();
}
