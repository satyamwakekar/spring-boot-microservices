package com.codeghoul.departmentsevice.repository;

import com.codeghoul.departmentsevice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentId(Long id);
}
