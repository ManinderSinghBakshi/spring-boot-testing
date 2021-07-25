package com.ongrid.nexusTesting.controller;

import com.ongrid.nexusTesting.model.Employee;
import com.ongrid.nexusTesting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        if (employee == null)
            throw new IllegalArgumentException("Employee not present");
        return employeeService.addEmployee(employee);
    }

    @PostMapping(path = "/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId")Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}
