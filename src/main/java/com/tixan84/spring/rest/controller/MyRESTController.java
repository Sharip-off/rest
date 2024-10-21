package com.tixan84.spring.rest.controller;

import com.tixan84.spring.rest.entity.Employee;
import com.tixan84.spring.rest.exception_hendling.EmployeeIncorrectData;
import com.tixan84.spring.rest.exception_hendling.NoSuchEmployeeException;
import com.tixan84.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with id " +
                    id + " in the database.");
        }

        return employee;
    }

}
