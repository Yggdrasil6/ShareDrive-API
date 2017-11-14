package com.yggdrasil.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/home")
    public String helloWorld() {
        return "Hello ShareDrive";
    }
}
