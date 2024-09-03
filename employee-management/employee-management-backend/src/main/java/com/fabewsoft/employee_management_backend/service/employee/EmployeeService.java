package com.fabewsoft.employee_management_backend.service.employee;

import com.fabewsoft.employee_management_backend.dto.EmployeeDTO;
import com.fabewsoft.employee_management_backend.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    public ResponseEntity<EmployeeDTO> saveEmployee(EmployeeDTO employeeDTO);

    public ResponseEntity<List<EmployeeDTO>> findAll();

    public EmployeeDTO getById(Integer id);

    public EmployeeDTO updateUserById(EmployeeDTO employeeDTO,Integer id);

    public boolean changeDepartment(Integer employeeId,Integer departmentId);

    String deleteUserById(Integer id);
}
