package com.fabewsoft.employee_management_backend.controller;

import com.fabewsoft.employee_management_backend.dto.DepartmentDTO;
import com.fabewsoft.employee_management_backend.dto.EmployeeDTO;
import com.fabewsoft.employee_management_backend.model.Department;
import com.fabewsoft.employee_management_backend.model.Employee;
import com.fabewsoft.employee_management_backend.repository.DepartmentRepository;
import com.fabewsoft.employee_management_backend.service.department.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin("http://localhost:3000")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DepartmentRepository departmentRepository;

    @PostMapping(value="/addDepartment",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object saveDepartment(@Valid @RequestBody DepartmentDTO departmentDTO, Errors errors){
        if(errors.hasErrors()){
            return errors.getAllErrors().get(0).getDefaultMessage();
        }else{
            return departmentService.save(departmentDTO);
        }
    }

    @GetMapping("/getAllDepts")
    public List<DepartmentDTO> allDepts(){
        List<DepartmentDTO> departmentDTOS = departmentService.findAll();
        if(departmentDTOS.size() > 0){
            return departmentDTOS;
        }else {
            return null;
        }
    }

    @GetMapping("/getAllEmployeesOfDept")
    public  List<EmployeeDTO> getAllEmployees(@RequestParam("id") Integer deptId){
        return departmentService.findAllEmployees(deptId);
    }
}
