package com.codeghoul.departmentsevice.controller;

import com.codeghoul.departmentsevice.entity.Department;
import com.codeghoul.departmentsevice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepsrtment(@RequestBody Department department) {
        log.info("Tying to add department with code {}", department.getDepartmentCode());
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable(value = "id") Long id) {
        return departmentService.getDepartmentById(id);
    }
}
