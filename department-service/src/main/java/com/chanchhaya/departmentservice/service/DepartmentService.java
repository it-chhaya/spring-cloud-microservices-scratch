package com.chanchhaya.departmentservice.service;

import com.chanchhaya.departmentservice.entity.Department;

public interface DepartmentService {
    Department save(Department department);
    Department findById(Long id);
}
