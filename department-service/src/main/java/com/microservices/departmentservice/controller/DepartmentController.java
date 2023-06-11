package com.microservices.departmentservice.controller;

import com.microservices.departmentservice.client.EmployeeClient;
import com.microservices.departmentservice.model.Department;
import com.microservices.departmentservice.model.Employee;
import com.microservices.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add :{}",department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable(value = "id") Long id){
        LOGGER.info("Department find by id={}",id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/")
    public List<Department> getAll(){
        LOGGER.info("Department find all");
        return departmentRepository.findAll();
    }

    @GetMapping("/with-employee")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("Department with employee:");
        List<Department> departments = departmentRepository.findAll();

        departments.forEach(department -> department.setEmplyees(employeeClient.getById(department.getId())));

        return departments;
    }



}
