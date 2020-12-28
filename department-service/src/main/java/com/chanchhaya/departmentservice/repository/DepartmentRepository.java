package com.chanchhaya.departmentservice.repository;

import com.chanchhaya.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
