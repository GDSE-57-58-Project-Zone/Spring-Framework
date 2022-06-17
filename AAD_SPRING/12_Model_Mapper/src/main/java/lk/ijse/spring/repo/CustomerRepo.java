package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface CustomerRepo extends JpaRepository<Customer, String> {
    Customer findCustomerByName(String name); //query methods
}
