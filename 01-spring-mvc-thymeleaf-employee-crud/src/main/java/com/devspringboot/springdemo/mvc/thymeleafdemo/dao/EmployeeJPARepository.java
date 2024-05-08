package com.devspringboot.springdemo.mvc.thymeleafdemo.dao;

import com.devspringboot.springdemo.mvc.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeJPARepository extends JpaRepository<Employee,Integer> {

    public List<Employee> findAllByOrderByLastNameAsc();
}
