package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/


@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    @Test
    void saveCustomer() {
        CustomerDTO customerDTO1 = new CustomerDTO("C001", "Ramal", "Galle", 1000.00);
        customerService.saveCustomer(customerDTO1);

        CustomerDTO customerDTO2 = new CustomerDTO("C001", "Ramal", "Galle", 1000.00);
        customerService.saveCustomer(customerDTO2);
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void searchCustomer() {
    }

    @Test
    void getAllCustomers() {
    }
}
