package com.chanchhaya.userservice.service.impl;

import com.chanchhaya.userservice.VO.Department;
import com.chanchhaya.userservice.VO.ResponseTemplateVO;
import com.chanchhaya.userservice.controller.UserController;
import com.chanchhaya.userservice.entity.User;
import com.chanchhaya.userservice.repository.UserRepository;
import com.chanchhaya.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public User save(User user) {
        LOGGER.info("save in UserServiceImpl");
        return userRepository.save(user);
    }

    @Override
    public ResponseTemplateVO getUserWithDepartmentById(Long id) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findById(id).orElse(null);

        LOGGER.info("getUserWithDepartmentById in UserServiceImpl");

        assert user != null;
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                        Department.class);
        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }

}
