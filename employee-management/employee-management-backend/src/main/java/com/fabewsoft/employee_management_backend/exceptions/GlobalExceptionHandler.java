package com.fabewsoft.employee_management_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleEmployeeNotFound(EmployeeNotFoundException employeeNotFoundException){
        Map<String,String> map = new HashMap<>();
        map.put("Message","Employee Not Found");
        map.put("status", HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
    }
}
