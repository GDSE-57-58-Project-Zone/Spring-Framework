package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("item")
public class ItemController {

    @GetMapping
    public String saveItem() {
        return "Item saved and Get Mapping Invoked";
    }
}
