package com.devspringboot.springdemo.mvc.thymeleafdemo.service;

import com.devspringboot.springdemo.mvc.thymeleafdemo.dao.EmployeeJPARepository;
import com.devspringboot.springdemo.mvc.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeJPARepository employeeJPARepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeJPARepository employeeJPARepository) {
        this.employeeJPARepository = employeeJPARepository;
    }


    @Override
    public List<Employee> findAll() {

        return employeeJPARepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(Integer theId) {

        Optional<Employee> result = employeeJPARepository.findById(theId);

        Employee employee = null;

        if(result.isPresent()){
            employee = result.get();
        }
        else{
            throw new RuntimeException("Employee with given Id not found Id- "+theId);
        }
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        return employeeJPARepository.save(theEmployee);
    }

    @Override
    public void deleteById(Integer theId) {

        employeeJPARepository.deleteById(theId);
    }
}
