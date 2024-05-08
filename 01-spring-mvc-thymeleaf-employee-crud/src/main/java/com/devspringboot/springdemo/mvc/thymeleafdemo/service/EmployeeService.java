package com.devspringboot.springdemo.mvc.thymeleafdemo.service;

import com.devspringboot.springdemo.mvc.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Integer theId);

    Employee save(Employee theEmployee);

    void deleteById(Integer theId);
}
