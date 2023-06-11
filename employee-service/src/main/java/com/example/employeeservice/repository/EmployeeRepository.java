package com.example.employeeservice.repository;

import com.example.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> employess = new ArrayList<>();

    public Employee add(Employee employee){
        employess.add(employee);
        return employee;
    }

    public Employee findById(Long id){
        return employess.stream().filter(employee -> employee.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAll(){
        return employess;
    }

    public List<Employee> findByDepartmentId(Long departmentId){
        return employess.stream().filter(employee -> employee.departmentId().equals(departmentId))
                .toList();
    }
}
