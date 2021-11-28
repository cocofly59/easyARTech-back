// This is a test
package eart.api.backend.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class TestRestController {
    @GetMapping("rest/test")
    public Map<String, String> test() {
        return Collections.singletonMap("value", "Hello guy !");
    }
}
