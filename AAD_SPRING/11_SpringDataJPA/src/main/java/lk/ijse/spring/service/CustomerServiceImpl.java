package lk.ijse.spring.service;

import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Service
@Transactional
public class CustomerServiceImpl {

    @Autowired
    private CustomerRepo repo;

    public void saveCustomer(Customer entity) {
        repo.save(entity);
    }

    public void deleteCustomer(String id) {
        repo.deleteById(id);
    }

    public void updateCustomer(Customer entity) {
        repo.save(entity);
    }

    public Customer searchCustomer(String id) {
        return repo.findById(id).get();
    }

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }
}
