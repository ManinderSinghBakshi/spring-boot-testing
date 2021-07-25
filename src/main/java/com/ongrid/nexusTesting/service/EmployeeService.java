package com.ongrid.nexusTesting.service;

import com.ongrid.nexusTesting.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    void deleteEmployee(Long employeeId);
}
