package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("exact")
public class ExactMappingController {
    // Exact Mapping = ....item/it/test1
    // Exact Mapping = ....item/test2/I0/tt1
    // path segment -> /it/

    @GetMapping(path = "it/test1")
    public String test() {
        return "Get Mapping Invoked (test)";
    }

    @GetMapping(path = "test2/I0/tt1")
    public String test2() {
        return "Get Mapping Invoked test2()";
    }
}
