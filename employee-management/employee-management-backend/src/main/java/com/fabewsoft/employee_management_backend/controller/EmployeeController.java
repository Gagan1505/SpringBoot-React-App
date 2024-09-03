package com.fabewsoft.employee_management_backend.controller;

import com.fabewsoft.employee_management_backend.dto.EmployeeDTO;
import com.fabewsoft.employee_management_backend.service.employee.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:3000")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value="/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.ofNullable(null);
        }else{
            return employeeService.saveEmployee(employeeDTO);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer id){
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @PutMapping("/updateUser/{id}")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO,@PathVariable Integer id){
        employeeService.updateUserById(employeeDTO,id);
        return employeeDTO;
    }

    @DeleteMapping("/deleteUser/{id}")
    String deleteUserById(@PathVariable Integer id){
        return employeeService.deleteUserById(id);
    }



    @PostMapping("/changeDepartment")
    public boolean changeDepartment(@RequestParam("empId") Integer empId,@RequestParam("deptId") Integer deptId){
        return employeeService.changeDepartment(empId,deptId);
    }
}
