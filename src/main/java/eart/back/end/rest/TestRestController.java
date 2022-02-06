// This is a test
package eart.back.end.rest;

import eart.back.end.models.Counter;
import eart.back.end.repositories.CarRepository;
import eart.back.end.repositories.CounterRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
@RestController
public class TestRestController {
    final static Logger LOGGER = LogManager.getLogger(TestRestController.class);

    @Autowired
    CarRepository repo;

    @Autowired
    CounterRepository counterRepository;

    @GetMapping("rest/test")
    public Map<String, String> test() {
        return Collections.singletonMap("value", "This is my other test value.");
    }/*
    public Map<String, List<Car>> test() {
        List<Car> cars = repo.findAll();
        return Collections.singletonMap("cars", cars);
    }*/

    @GetMapping("rest/hello")
    public String hello() {
        return "hello world !";
    }

    @GetMapping("rest/counter/get/{id}")
    public Map<String, Counter> getCounter(@PathVariable("id") String id) {
        return Collections.singletonMap("value", getOrCreateCounter(id));
    }

    @GetMapping("rest/counter/increment/{id}")
    public Map<String, Counter> incrementCounter(@PathVariable("id") String id) {
        Counter counter = getOrCreateCounter(id);
        counter.value += 1;
        counterRepository.saveAndFlush(counter);
        return Collections.singletonMap("value", counter);
    }

    @GetMapping("rest/counter/decrement/{id}")
    public Map<String, Counter> decrementCounter(@PathVariable("id") String id) {
        Counter counter = getOrCreateCounter(id);
        counter.value -= 1;
        counterRepository.saveAndFlush(counter);
        return Collections.singletonMap("value", counter);
    }

    @GetMapping("rest/counter/reset/{id}")
    public Map<String, Counter> resetCounter(@PathVariable("id") String id) {
        Counter counter = getOrCreateCounter(id);
        counter.value = 0;
        counterRepository.saveAndFlush(counter);
        return Collections.singletonMap("value", counter);
    }

    private Counter getOrCreateCounter(String id) {
        Optional<Counter> counter = counterRepository.findById(id.trim());
        if (counter.isPresent()) {
            return counter.get();
        } else {
            Counter aCounter = new Counter();
            aCounter.name = id.trim();
            aCounter.value = 0;
            counterRepository.saveAndFlush(aCounter);
            return aCounter;
        }
    }
}
