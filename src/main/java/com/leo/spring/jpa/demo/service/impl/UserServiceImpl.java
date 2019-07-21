package com.leo.spring.jpa.demo.service.impl;

import com.leo.spring.jpa.demo.entity.User;
import com.leo.spring.jpa.demo.po.XxPage;
import com.leo.spring.jpa.demo.respository.UserRepository;
import com.leo.spring.jpa.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> all(){
        List<User> all = userRepository.findAll();
        return all;
    }

    @Override
    public XxPage<User> list(XxPage xxPage) {
        PageRequest jpaPage = xxPage.jpaPage(new Sort(Sort.Direction.DESC, "id"));
        Page<User> userPage = userRepository.findAll(jpaPage);
        return XxPage.transformPage(userPage);
    }

    @Override
    public XxPage<User> list(User user, XxPage xxPage) {
        PageRequest jpaPage = xxPage.jpaPage(new Sort(Sort.Direction.DESC, "id"));
        Example<User> example = Example.of(user);
        Page<User> userPage = userRepository.findAll(example, jpaPage);
        return XxPage.transformPage(userPage);
    }

}
