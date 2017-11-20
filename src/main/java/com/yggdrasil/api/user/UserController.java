package com.yggdrasil.api.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
public class UserController {
    @RequestMapping("/api/logins")
    public String helloWorld() {
        System.out.println(RequestContextHolder.getRequestAttributes().getSessionId());
        return "Hello ShareDrive";

    }
    @RequestMapping("/api/login")
    public String helloWorlds() {
        System.out.println(RequestContextHolder.getRequestAttributes().getSessionId());
        return "Hello ShareDrive";

    }
}
