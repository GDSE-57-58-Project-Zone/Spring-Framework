package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@SpringBootTest
class ItemRepoTest {

    @Autowired
    ItemRepo itemRepo;

    @Test // Test method
    public void saveItem() {
        //Ok let's save a customer using Customer Repo
        Item item1 = new Item("I001", "Eggs", 100, 1000.00);
        Item item2 = new Item("I002", "Signal", 200, 2000.00);
        Item item3 = new Item("I003", "LightBoy", 300, 3000.00);
        itemRepo.save(item1);
        itemRepo.save(item2);
        itemRepo.save(item3);
    }

    @Test
    public void getAllItems() {
        List<Item> all = itemRepo.findAll();
        for (Item item : all) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void searchItem() {
        Optional<Item> optional = itemRepo.findById("I001");
        boolean present = optional.isPresent();
        System.out.println(present);

        Item item = optional.get();
        System.out.println(item);

    }

    @Test
    public void deleteItem() {
        itemRepo.deleteById("I002");
    }

    @Test
    public void updateItem() {
        if (itemRepo.existsById("I001")) {
            Item item1 = new Item("I001", "Signal", 100, 1000.00);
            itemRepo.save(item1);
        } else {
            throw new RuntimeException("No Such Item To Update");
        }

    }


}
