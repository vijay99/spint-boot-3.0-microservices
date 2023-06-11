package com.microservices.departmentservice.model;

import io.micrometer.core.instrument.util.AbstractPartition;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private Long id;
    private String name;
    private List<Employee> emplyees = new ArrayList<>();

    public Department() {
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmplyees() {
        return emplyees;
    }

    public void setEmplyees(List<Employee> emplyees) {
        this.emplyees = emplyees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emplyees=" + emplyees +
                '}';
    }
}
