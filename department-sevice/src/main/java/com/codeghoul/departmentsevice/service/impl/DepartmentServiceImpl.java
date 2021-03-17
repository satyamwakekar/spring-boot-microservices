package com.codeghoul.departmentsevice.service.impl;

import com.codeghoul.departmentsevice.entity.Department;
import com.codeghoul.departmentsevice.repository.DepartmentRepository;
import com.codeghoul.departmentsevice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        log.info("Trying to insert department with department code {}", department.getDepartmentCode());
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        log.info("Trying to fetch department by id {}", id);
        return departmentRepository.findByDepartmentId(id);
    }
}
