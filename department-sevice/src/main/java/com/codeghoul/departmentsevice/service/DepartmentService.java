package com.codeghoul.departmentsevice.service;

import com.codeghoul.departmentsevice.entity.Department;

public interface DepartmentService {

    Department saveDepartment(Department department);

    Department getDepartmentById(Long id);
}
