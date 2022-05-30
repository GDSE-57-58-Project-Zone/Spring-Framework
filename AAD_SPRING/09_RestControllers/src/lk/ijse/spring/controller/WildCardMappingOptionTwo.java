package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("two")
public class WildCardMappingOptionTwo {

    //http://localhost:8080/appname/path/path2/path (path segments)

    //Wild Card Mapping Option Two
    //Matches 0 or More Characters in path segments until the end of the path
    //test/**/hello -> test//hello  (matching)
    //test/**/hello -> test/hello  (matching)
    //test/**/hello -> test/11111/111111/hello (matching)
    //test/**/hello -> test/abcde/hello (matching)
    //test/**/hello -> test/abc/deeeee/eeeee/hello (matching)
    //test/**/hello -> tested/abc/deeeee/eeeee/hello (Not matching)
    //test/**/hello -> test/abc/deeeee/eeeee (Not matching)


    @GetMapping(path = "test/**/hello")
    public String test() {
        return "Get Mapping Invoked (test)";
    }

    @GetMapping(path = "hello/**/ijse")
    public String test2() {
        return "Get Mapping Invoked test2()";
    }
}
