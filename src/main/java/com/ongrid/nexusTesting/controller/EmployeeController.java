package com.ongrid.nexusTesting.controller;

import com.ongrid.nexusTesting.model.Employee;
import com.ongrid.nexusTesting.repository.EmployeeRepository;
import com.ongrid.nexusTesting.service.EmployeeService;
import com.ongrid.nexusTesting.service.object.AddEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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
    public Employee addEmployee(@RequestBody AddEmployeeRequest request){
        if (request == null)
            throw new IllegalArgumentException("Add employee request not present");
        return employeeService.addEmployee(request);
    }

    @PostMapping(path = "/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId")Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}
