package com.fabewsoft.employee_management_backend.dto;

import com.fabewsoft.employee_management_backend.model.Department;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@RequiredArgsConstructor
@ToString
public class EmployeeDTO {

    private Integer employeeId;

    @NotEmpty(message = "*Name should not ne empty")
    @NotBlank(message = "*name cant be blank")
    @Size(min = 3,max = 30,message = "*Name should contain 3 to 30 characters")
    private String employeeName;

    @NotEmpty(message = "* Email should not ne empty")
    @NotNull(message = "*mail cant be null")
    private String employeeEmail;

    @NotEmpty(message = "* Address should not ne empty")
    private String employeeAddress;

    private Date employeeDOB;

    @NotEmpty(message = "*Name cannot be empty")
    private String designation;

    private Integer employeeDepartment;

    public Integer getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(Integer employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    private DepartmentDTO departmentDTO;

    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }

    public void setDepartmentDTO(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }

    public @NotEmpty(message = "*Name should not ne empty") @NotBlank(message = "*name cant be blank") @Size(min = 3, max = 30, message = "*Name should contain 3 to 30 characters") String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(@NotEmpty(message = "*Name should not ne empty") @NotBlank(message = "*name cant be blank") @Size(min = 3, max = 30, message = "*Name should contain 3 to 30 characters") String employeeName) {
        this.employeeName = employeeName;
    }

    public @NotEmpty(message = "* Email should not ne empty") @NotNull(message = "*mail cant be null") String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(@NotEmpty(message = "* Email should not ne empty") @NotNull(message = "*mail cant be null") String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public @NotEmpty(message = "* Address should not ne empty") String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(@NotEmpty(message = "* Address should not ne empty") String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Date getEmployeeDOB() {
        return employeeDOB;
    }

    public void setEmployeeDOB(Date employeeDOB) {
        this.employeeDOB = employeeDOB;
    }

    public @NotEmpty(message = "*Name cannot be empty") String getDesignation() {
        return designation;
    }

    public void setDesignation(@NotEmpty(message = "*Name cannot be empty") String designation) {
        this.designation = designation;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
