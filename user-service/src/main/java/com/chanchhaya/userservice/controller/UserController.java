package com.chanchhaya.userservice.controller;

import com.chanchhaya.userservice.VO.ResponseTemplateVO;
import com.chanchhaya.userservice.entity.User;
import com.chanchhaya.userservice.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public User save(@RequestBody User user) {
        LOGGER.info("Insert save of UserController");
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartmentById(@PathVariable("id") Long id) {
        LOGGER.info("getUserWithDepartmentById in UserController");
        return userService.getUserWithDepartmentById(id);
    }

}
