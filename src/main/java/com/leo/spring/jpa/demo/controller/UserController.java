package com.leo.spring.jpa.demo.controller;

import com.leo.spring.jpa.demo.entity.User;
import com.leo.spring.jpa.demo.po.XxPage;
import com.leo.spring.jpa.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    List<User> all(){
        List<User> all = userService.all();
        for (User user : all) {
            log.info(user.toString());
        }
        return all;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    XxPage<User> list(
            @RequestParam("current") Integer current,
            @RequestParam("size") Integer size,
            @RequestBody User user
    ){
        XxPage<?> xxPage = new XxPage(current, size);
        return userService.list(user, xxPage);
    }

}
