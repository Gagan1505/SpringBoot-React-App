package com.fabewsoft.employee_management_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@RequiredArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;
    private String departmentName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", referencedColumnName = "employee_id")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(@NotEmpty(message = "Department name cannot be empty") String departmentName) {
        this.departmentName = departmentName;
    }

    public @NotEmpty(message = "Department name cannot be empty") String getDepartmentName() {
        return departmentName;
    }

}
