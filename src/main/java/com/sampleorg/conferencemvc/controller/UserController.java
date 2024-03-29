package com.sampleorg.conferencemvc.controller;

import com.sampleorg.conferencemvc.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(@RequestParam(value = "firstname", defaultValue = "sampleFirstName") String firstname,
                        @RequestParam(value = "lastname", defaultValue = "sampleLastName") String lastname,
                        @RequestParam(value = "age", defaultValue = "20") int age) {
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user")
    public User postUser(User user) {
        System.out.println("Obtained input for user:"+user.getFirstname()+user.getLastname()+user.getAge());
        user.setAge(user.getAge()+20);
        return user;
    }
}
