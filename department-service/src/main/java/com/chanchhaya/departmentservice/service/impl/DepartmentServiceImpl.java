package com.chanchhaya.departmentservice.service.impl;

import com.chanchhaya.departmentservice.entity.Department;
import com.chanchhaya.departmentservice.repository.DepartmentRepository;
import com.chanchhaya.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department save(Department department) {
        log.info("save in DepartmentServiceImpl");
        return departmentRepository.save(department);
    }

    @Override
    public Department findById(Long id) {
        log.info("findById in DepartmentServiceImpl");
        return departmentRepository.findById(id).orElse(null);
    }
}
