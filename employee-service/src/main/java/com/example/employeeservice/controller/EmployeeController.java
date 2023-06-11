package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee  add(@RequestBody Employee employee){
        LOGGER.info("Employee add :{}",employee);
        return employeeRepository.add(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        LOGGER.info("Get all Employee");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Long id){
        LOGGER.info("Get Employee by id:{}",id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getByDepartment(@PathVariable(value = "departmentId") Long deptId){
        LOGGER.info("Get Employee by deptId:{}",deptId);
        return employeeRepository.findByDepartmentId(deptId);
    }

}
