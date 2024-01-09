package cz.weatherAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @RequestMapping("/hello")
    String hello(){
        return "Ahoj vsichni";
    }
    @RequestMapping("/greeting")
    String greeting(){
        return "Hello spring world";
    }
}
