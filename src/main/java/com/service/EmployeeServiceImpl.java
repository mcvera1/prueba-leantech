package com.service;

import com.gateway.EmployeeGateway;
import com.gateway.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeGateway employeeGateway;

    public EmployeeServiceImpl(EmployeeGateway employeeGateway) {
        this.employeeGateway = employeeGateway;
    }

    @Override
    public void createEmployee(EmployeeRequest employeeRequest) {
        employeeGateway.createEmployee(employeeRequest);
    }

    @Override
    public List<Employee> getEmployee(String name, String position) {
        return employeeGateway.getEmployee(name, position);
    }

    @Override
    public Employee updateEmployee(EmployeeRequest request) {
        return employeeGateway.updateEmployee(request);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeGateway.deleteEmployee(id);
    }
}
