package com.ongrid.nexusTesting.service;

import com.ongrid.nexusTesting.model.Employee;
import com.ongrid.nexusTesting.service.object.AddEmployeeRequest;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee addEmployee(AddEmployeeRequest request);

    public void deleteEmployee(Long employeeId);
}
