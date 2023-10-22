package com.example.rhproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private String title="hello, i'm the user Micro Service";
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println(title);
        return title;
    }
}
