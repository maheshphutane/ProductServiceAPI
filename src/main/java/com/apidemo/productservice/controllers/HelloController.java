package com.apidemo.productservice.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/say/{name}")
    public String sayHello(@PathVariable("name") String name){
        return "hellooo "+name+"!!";
    }
}
