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

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/


@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional // dont commit anything to database // just test is it working properly or not
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    public CustomerDTO addTestCustomers() {
        //If it is a new Customer It should added to the database
        return new CustomerDTO("C001", "Ramal", "Galle", 1000.00);
    }


    @Test
    void saveCustomer() {

        CustomerDTO customerDTO = addTestCustomers();
        //Check there is no errors
        //If there are no errors test ok
        //If there are errors test is false
        assertDoesNotThrow(() -> {
            customerService.saveCustomer(customerDTO);
        });


        // If the customer already exist. check if it is throwing the error
        CustomerDTO customerDTO2 =addTestCustomers();

        //Check if there is a error. If there is a error test is ok
        //If there is no error test case false
        assertThrows(RuntimeException.class, () -> {
            customerService.saveCustomer(customerDTO2);
        });

    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void searchCustomer() {
        CustomerDTO customerDTO1 = addTestCustomers();

        customerService.saveCustomer(customerDTO1);

        CustomerDTO c001 = customerService.searchCustomer("C001");

        assertNotNull(c001);



        assertThrows(RuntimeException.class, () -> {
            CustomerDTO c002 = customerService.searchCustomer("C002");
        });


    }

    @Test
    void getAllCustomers() {
    }
}
