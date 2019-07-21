package com.leo.spring.jpa.demo.service;

import com.leo.spring.jpa.demo.entity.User;
import com.leo.spring.jpa.demo.po.XxPage;

import java.util.List;

public interface UserService {

    List<User> all();

    XxPage<User> list(XxPage xxPage);

    XxPage<User> list(User user, XxPage xxPage);
}
