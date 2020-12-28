package com.chanchhaya.userservice.service;

import com.chanchhaya.userservice.VO.ResponseTemplateVO;
import com.chanchhaya.userservice.entity.User;

public interface UserService {

    User save(User user);

    ResponseTemplateVO getUserWithDepartmentById(Long id);

}
