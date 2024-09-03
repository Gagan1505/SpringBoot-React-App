package com.fabewsoft.employee_management_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@ToString
public class DepartmentDTO {

    private Integer departmentId;

    @JsonProperty(value = "departmentName")
    @NotEmpty(message = "Department name cannot be empty")
    private String departmentName;

    private List<EmployeeDTO> employeeDTOS;

    public @NotEmpty(message = "Department name cannot be empty") String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(@NotEmpty(message = "Department name cannot be empty") String departmentName) {
        this.departmentName = departmentName;
    }

    public List<EmployeeDTO> getEmployeeDTOS() {
        return employeeDTOS;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public void setEmployeeDTOS(List<EmployeeDTO> employeeDTOS) {
        this.employeeDTOS = employeeDTOS;
    }
}
