package com.chanchhaya.departmentservice.controller;

import com.chanchhaya.departmentservice.entity.Department;
import com.chanchhaya.departmentservice.service.impl.DepartmentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;

    @Autowired
    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department save(@RequestBody Department department) {
        log.info("save in department controller");
        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) {
        log.info("find by ID in department controller");
        return departmentService.findById(id);
    }
}
