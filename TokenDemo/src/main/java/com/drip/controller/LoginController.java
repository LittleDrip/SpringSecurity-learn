package com.drip.controller;

import com.drip.domain.User;
import com.drip.service.LoginService;
import com.drip.service.UserService;
import com.drip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;
    @PostMapping("/user/login")
    public Result login(@RequestBody User user){
//        登录
        Result result= loginService.login(user);
        return result;
    }
}
