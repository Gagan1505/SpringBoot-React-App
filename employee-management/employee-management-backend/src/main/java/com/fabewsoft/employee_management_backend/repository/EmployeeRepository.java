package com.fabewsoft.employee_management_backend.repository;

import com.fabewsoft.employee_management_backend.model.Department;
import com.fabewsoft.employee_management_backend.model.Employee;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.processing.HQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Modifying
    @Query(value = "UPDATE EMPLOYEE E SET E.DEPARTMENT_ID = :dept WHERE E.EMPLOYEE_ID = :empId",nativeQuery = true)
    public int changeDepartment(@Param("empId")Integer employeeId, @Param("dept") Integer departmentId);

}
