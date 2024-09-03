package com.fabewsoft.employee_management_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;

@Entity
@RequiredArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @NotEmpty(message = "*Name should not ne empty")
    @NotBlank(message = "*name cant be blank")
    @Size(min = 3,max = 30,message = "*Name should contain 3 to 30 characters")
    private String employeeName;

    @NotEmpty(message = "* Email should not ne empty")
    @NotNull(message = "*mail cant be null")
    @Column(name = "employee_email",unique = true)
    private String employeeEmail;

    @NotEmpty(message = "* Address should not ne empty")
    private String employeeAddress;

    private Date employeeDOB;

    @NotEmpty(message = "*Name cannot be empty")
    private String designation;

    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "departmentId")
    private Department department;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public @NotEmpty(message = "*Name should not ne empty") @NotBlank(message = "*name cant be blank") @Size(min = 3, max = 30, message = "*Name should contain 3 to 30 characters") String getEmployeeName() {
        return employeeName;
    }

    public @NotEmpty(message = "* Email should not ne empty") @NotNull(message = "*mail cant be null") String getEmployeeEmail() {
        return employeeEmail;
    }

    public @NotEmpty(message = "* Address should not ne empty") String getEmployeeAddress() {
        return employeeAddress;
    }

    public Date getEmployeeDOB() {
        return employeeDOB;
    }

    public @NotEmpty(message = "*Name cannot be empty") String getDesignation() {
        return designation;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(@NotEmpty(message = "*Name should not ne empty") @NotBlank(message = "*name cant be blank") @Size(min = 3, max = 30, message = "*Name should contain 3 to 30 characters") String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeEmail(@NotEmpty(message = "* Email should not ne empty") @NotNull(message = "*mail cant be null") String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public void setEmployeeAddress(@NotEmpty(message = "* Address should not ne empty") String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public void setEmployeeDOB(Date employeeDOB) {
        this.employeeDOB = employeeDOB;
    }

    public void setDesignation(@NotEmpty(message = "*Name cannot be empty") String designation) {
        this.designation = designation;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
