package com.fabewsoft.employee_management_backend.service.employee;


import com.fabewsoft.employee_management_backend.dto.DepartmentDTO;
import com.fabewsoft.employee_management_backend.dto.EmployeeDTO;
import com.fabewsoft.employee_management_backend.exceptions.EmployeeNotFoundException;
import com.fabewsoft.employee_management_backend.model.Department;
import com.fabewsoft.employee_management_backend.model.Employee;
import com.fabewsoft.employee_management_backend.repository.DepartmentRepository;
import com.fabewsoft.employee_management_backend.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    public ResponseEntity<EmployeeDTO> saveEmployee(EmployeeDTO employeeDTO) {
        if(employeeDTO != null){
            System.err.println(employeeDTO);
            Employee employee = new Employee();
            Integer deptId = employeeDTO.getEmployeeDepartment();

            Department department = departmentRepository.getById(deptId);

            employee.setDepartment(department);

            BeanUtils.copyProperties(employeeDTO,employee);
            department.getEmployees().add(employee);
            if(employeeRepository.save(employee) != null){
                return ResponseEntity.ok(employeeDTO);
            }else{
                return ResponseEntity.status(404).build();
            }
        }else{
            return null;
        }
    }

    @Override
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for(Employee employee:employeeRepository.findAll()){
            EmployeeDTO employeeDTO = new EmployeeDTO();

            DepartmentDTO departmentDTO = new DepartmentDTO();
            Department department= departmentRepository.getById(employee.getDepartment().getDepartmentId());
            BeanUtils.copyProperties(department,departmentDTO);

            employeeDTO.setDepartmentDTO(departmentDTO);
            BeanUtils.copyProperties(employee,employeeDTO);
            employeeDTOS.add(employeeDTO);
        }
        if(employeeDTOS.size()>0)
            return ResponseEntity.ok(employeeDTOS);
        else{
            return new ResponseEntity<>(null,
            HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public EmployeeDTO getById(Integer id) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Not found"));
        employeeDTO.setEmployeeDepartment(employee.getDepartment().getDepartmentId());
        BeanUtils.copyProperties(employee,employeeDTO,"department");
        return employeeDTO;
    }

    @Override
    public EmployeeDTO updateUserById(EmployeeDTO employeeDTO, Integer id) {
        employeeRepository.findById(id)
                .map(employee -> {
                    employee.setEmployeeName(employeeDTO.getEmployeeName());
                    employee.setEmployeeAddress(employeeDTO.getEmployeeAddress());
                    employee.setEmployeeDOB(employeeDTO.getEmployeeDOB());
                    employee.setEmployeeEmail(employeeDTO.getEmployeeEmail());
                    employee.setDesignation(employeeDTO.getDesignation());
                    return employeeRepository.save(employee);
                }).orElseThrow(() -> new EmployeeNotFoundException("Not found to update"));
        return employeeDTO;
    }

    @Override
    public boolean changeDepartment(Integer employeeId, Integer departmentId) {
        Department department = departmentRepository.getById(departmentId);

        if(employeeRepository.changeDepartment(employeeId,departmentId) > 0)
            return true;
        else
            return false;
    }

    @Override
    public String deleteUserById(Integer id) {
        if(!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException("Not found with id "+id);
        }
        employeeRepository.deleteById(id);
        return "Employee with id : "+id+" has been deleted";
    }
}
