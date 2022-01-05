// This is a test
package eart.back.end.rest;

import eart.back.end.models.Car;
import eart.back.end.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@RestController
public class TestRestController {
    @Autowired
    CarRepository repo;
    @GetMapping("rest/test")
    public Map<String, List<Car>> test() {
        List<Car> cars = repo.findAll();
        return Collections.singletonMap("cars", cars);
    }

    @GetMapping("rest/hello")
    public String hello() {
        return "hello world !";
    }
}
