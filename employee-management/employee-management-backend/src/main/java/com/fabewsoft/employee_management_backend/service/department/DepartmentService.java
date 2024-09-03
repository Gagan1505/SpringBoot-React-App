package com.fabewsoft.employee_management_backend.service.department;

import com.fabewsoft.employee_management_backend.dto.DepartmentDTO;
import com.fabewsoft.employee_management_backend.dto.EmployeeDTO;
import com.fabewsoft.employee_management_backend.model.Department;

import java.util.List;

public interface DepartmentService {

    public Department save(DepartmentDTO departmentDTO);

    public Department getById(Integer id);

    public List<DepartmentDTO> findAll();

    public List<EmployeeDTO> findAllEmployees(Integer departmentId);
}
