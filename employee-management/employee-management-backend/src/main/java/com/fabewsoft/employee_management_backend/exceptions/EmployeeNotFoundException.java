package com.fabewsoft.employee_management_backend.exceptions;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String message){
        System.out.println("No employee found");
    }
}
