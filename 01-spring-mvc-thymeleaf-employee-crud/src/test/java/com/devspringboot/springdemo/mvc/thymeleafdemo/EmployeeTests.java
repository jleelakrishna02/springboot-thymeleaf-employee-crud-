package com.devspringboot.springdemo.mvc.thymeleafdemo;

import com.devspringboot.springdemo.mvc.thymeleafdemo.dao.EmployeeJPARepository;
import com.devspringboot.springdemo.mvc.thymeleafdemo.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeTests {

    @Autowired
    private EmployeeJPARepository employeeJPARepository;

    @Test
    @Rollback(value = false)
    public void testCreateEmployee(){
        Employee employee = new Employee("Leela Krishna","Jammula","leela@gmail.com");
        Employee employee1 = employeeJPARepository.save(employee);

        assertNotNull(employee1);
    }

    @Test
    public void getEmployeeTest(){

        int theId =2;
        employeeJPARepository.findById(theId);
    }

    @Test
    public void getAllEmployeesTest(){

        List<Employee> employeeList = (List<Employee>) employeeJPARepository.findAll();

        for(Employee temp : employeeList){
            System.out.println(temp);
        }
        assertThat(employeeList.size()).isGreaterThan(0);

    }
    @Test
    @Rollback(value = false)
    public void updateEmployeeTest(){

        Employee employee = new Employee("Leela krishna","Jammula","leela.jammula@gmail.com");
        employee.setId(2);

        Employee theEmployee = employeeJPARepository.save(employee);

        assertNotNull(theEmployee);
    }

    @Test
    @Rollback(value = false)
    public void deleteEmployeeTest(){

        int theId = 39;
        employeeJPARepository.deleteById(theId);

        boolean isIdDeleted = employeeJPARepository.findById(theId).isPresent();

        assertFalse(isIdDeleted);
    }

}
