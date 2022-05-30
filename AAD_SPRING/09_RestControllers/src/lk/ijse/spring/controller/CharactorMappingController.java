package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("charactor")
public class CharactorMappingController {

    // item/I333
    // item/Ivff
    // item/I001

    @GetMapping(path = "item/I???")
    public String test() {
        return "Get Mapping Invoked (test)";
    }

//
//    @GetMapping(path = "")
//    public String test2() {
//        return "Get Mapping Invoked test2()";
//    }
//
}
