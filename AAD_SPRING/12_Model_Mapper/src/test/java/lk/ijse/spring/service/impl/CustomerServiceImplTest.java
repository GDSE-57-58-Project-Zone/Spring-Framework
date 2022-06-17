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

import java.util.List;

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

    //add One Customer for testing
    public CustomerDTO addOneCustomer() {
        //If it is a new Customer It should added to the database
        return new CustomerDTO("C001", "Ramal", "Galle", 1000.00);
    }

    //Add multiple customers for testing
    public void addCustomers(){
        CustomerDTO c1 = new CustomerDTO("C001","Dasun","Galle",100);
        CustomerDTO c2 = new CustomerDTO("C002","Kamal","Panadura",200);
        CustomerDTO c3 = new CustomerDTO("C003","Ramal","Kaluthara",300);
        CustomerDTO c4 = new CustomerDTO("C004","Oshan","Colombo",400);
        customerService.saveCustomer(c1);
        customerService.saveCustomer(c2);
        customerService.saveCustomer(c3);
        customerService.saveCustomer(c4);
    }


    @Test
    void saveCustomer() {

        CustomerDTO customerDTO = addOneCustomer();
        //Check there is no errors
        //If there are no errors test ok
        //If there are errors test is false
        assertDoesNotThrow(() -> {
            customerService.saveCustomer(customerDTO);
        });

        // If the customer already exist. check if it is throwing the error
        CustomerDTO customerDTO2 =addOneCustomer();

        //Check if there is a error. If there is a error test is ok
        //If there is no error test case false
        assertThrows(RuntimeException.class, () -> {
            customerService.saveCustomer(customerDTO2);
        });

    }

    @Test
    void deleteCustomer() {
        //Add multiple customers
        addCustomers();

        // delete existing customer
        assertDoesNotThrow(()->{
            customerService.deleteCustomer("C001");
        });

        //delete an non existing customer
        assertThrows(RuntimeException.class,()->{
            customerService.deleteCustomer("C016");
        });

    }

    @Test
    void updateCustomer() {
        //Add multiple customers
        addCustomers();

        //update an existing customer
        assertDoesNotThrow(()->{
            customerService.updateCustomer(new CustomerDTO("C001", "Ramal", "Galle", 10000.00));
        });

        //update an non existing customer
        //should throw an exception
        assertThrows(RuntimeException.class,()->{
            customerService.updateCustomer(new CustomerDTO("C005", "Ramal", "Galle", 10000.00));
        });



    }

    @Test
    void searchCustomer() {
        CustomerDTO customer = addOneCustomer();
        customerService.saveCustomer(customer);

        //search an available customer
        CustomerDTO c001 = customerService.searchCustomer("C001");
        assertNotNull(c001); // check customer is null or not

        /*
        check non existing customer
        should throw error
        */
        assertThrows(RuntimeException.class, () -> {
            CustomerDTO c002 = customerService.searchCustomer("C002");
        });


    }

    @Test
    void getAllCustomers() {
        //add multiple customers
        addCustomers();

        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        for (CustomerDTO allCustomer : allCustomers) {
            System.out.println(allCustomer.toString());
        }

        //Test customer availability
        assertNotNull(allCustomers);

    }
}
