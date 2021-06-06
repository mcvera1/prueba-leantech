package com.gateway;

import com.gateway.model.Employee;
import com.service.EmployeeService;

import java.util.List;

public interface EmployeeGateway {
    void createEmployee(EmployeeService.EmployeeRequest employeeRequest);

    List<Employee> getEmployee(String name, String position);

    Employee updateEmployee(EmployeeService.EmployeeRequest request);

    void deleteEmployee(Long id);
}
