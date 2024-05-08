package com.devspringboot.springdemo.mvc.thymeleafdemo.controller;

import com.devspringboot.springdemo.mvc.thymeleafdemo.entity.Employee;
import com.devspringboot.springdemo.mvc.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model model){

        //get employees from DB
        List<Employee> theEmployees = employeeService.findAll();

        //add to the Spring model
        model.addAttribute("employees",theEmployees);

        return "employees/list-employees";
    }
    @GetMapping("/showFormForAdd")
    public String saveForm(Model model){

        Employee theEmployee = new Employee();

        model.addAttribute("employee",theEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        //save the employee
        employeeService.save(theEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";

    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model){

        //get employee by id
        Employee theEmployee = employeeService.findById(theId);

        // set employee in the model to prepopulate the form
        model.addAttribute("employee",theEmployee);

        //send over to the form
        return "employees/employee-form";

    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId){

        employeeService.deleteById(theId);

        return "redirect:/employees/list";
    }

}
