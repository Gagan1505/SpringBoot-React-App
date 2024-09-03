package com.fabewsoft.employee_management_backend.service.department;

import com.fabewsoft.employee_management_backend.dto.DepartmentDTO;
import com.fabewsoft.employee_management_backend.dto.EmployeeDTO;
import com.fabewsoft.employee_management_backend.model.Department;
import com.fabewsoft.employee_management_backend.model.Employee;
import com.fabewsoft.employee_management_backend.repository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department save(DepartmentDTO departmentDTO) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentDTO,department);
        return departmentRepository.save(department);
    }

    @Override
    public Department getById(Integer id) {
        return departmentRepository.getById(id);
    }

    @Override
    public List<DepartmentDTO> findAll() {
        List<Department> departmentList = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        for(Department dept : departmentList){
            DepartmentDTO departmentDTO = new DepartmentDTO();
            BeanUtils.copyProperties(dept,departmentDTO,"employees");
            departmentDTOS.add(departmentDTO);
        }

        return departmentDTOS;
    }

    @Override
    public List<EmployeeDTO> findAllEmployees(Integer departmentId) {

        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        List<Employee> employees = departmentRepository.findAllEmployees(departmentId);
        for(Employee emp:employees){
            EmployeeDTO dto = new EmployeeDTO();
            BeanUtils.copyProperties(emp,dto);
            employeeDTOS.add(dto);
        }

        return employeeDTOS;
    }
}
