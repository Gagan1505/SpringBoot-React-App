package com.fabewsoft.employee_management_backend.repository;

import com.fabewsoft.employee_management_backend.model.Department;
import com.fabewsoft.employee_management_backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    public Department save(Department department);

    public Department getById(Integer id);

    public List<Department> findAll();

    @Transactional
    @Query(value = "SELECT D.employees FROM Department D WHERE D.departmentId =:deptId",nativeQuery = false)
    public List<Employee> findAllEmployees(@Param("deptId") Integer deptId);
}
