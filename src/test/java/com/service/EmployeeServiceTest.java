package com.service;

import static org.mockito.Mockito.*;

import com.gateway.EmployeeGateway;
import com.gateway.model.Candidate;
import com.gateway.model.Employee;
import com.gateway.model.Position;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeGateway employeeGateway;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    public void createEmployee() {
        EmployeeService.EmployeeRequest employeeRequest = new EmployeeService.EmployeeRequest();
        employeeRequest.setId(1L);
        employeeRequest.setCandidate(new Candidate());
        employeeRequest.setPosition(new Position());
        employeeRequest.setSalary(4.3F);
        employeeService.createEmployee(employeeRequest);
        verify(employeeGateway, Mockito.times(1)).createEmployee(employeeRequest);
    }

    @Test
    public void getEmployee() {
        List<Employee> result = Arrays.asList(new Employee(1L, new Candidate(1L, "name", "lastName", "address", 123L, "city"), new Position(1L, "namePosition"), 2.3F));
        when(employeeGateway.getEmployee(null, null)).thenReturn(result);
        List<Employee> getEmployee = employeeService.getEmployee(null, null);
        Assert.assertTrue(getEmployee.size() > 0);
    }

    @Test
    public void getEmployeeByEmployeeName() {
        List<Employee> result = Arrays.asList(new Employee(1L, new Candidate(1L, "name", "lastName", "address", 123L, "city"), new Position(1L, "namePosition"), 2.3F));
        when(employeeGateway.getEmployee("name", null)).thenReturn(result);
        List<Employee> getEmployee = employeeService.getEmployee("name", null);
        Assert.assertTrue(getEmployee.size() > 0);
    }

    @Test
    public void getEmployeeByEmployeePositionName() {
        List<Employee> result = Arrays.asList(new Employee(1L, new Candidate(1L, "name", "lastName", "address", 123L, "city"), new Position(1L, "namePosition"), 2.3F));
        when(employeeGateway.getEmployee(null, "namePosition")).thenReturn(result);
        List<Employee> getEmployee = employeeService.getEmployee(null, "namePosition");
        Assert.assertTrue(getEmployee.size() > 0);
    }

    @Test
    public void updateEmployee() {
        Employee employee = new Employee(1L, new Candidate(1L, "name", "lastName", "address", 123L, "city"), new Position(1L, "namePosition"), 2.3F);
        EmployeeService.EmployeeRequest employeeRequest = new EmployeeService.EmployeeRequest();
        employeeRequest.setId(1L);
        employeeRequest.setCandidate(new Candidate());
        employeeRequest.setPosition(new Position());
        employeeRequest.setSalary(4.3F);
        when(employeeGateway.updateEmployee(employeeRequest)).thenReturn(employee);
        Employee result = employeeService.updateEmployee(employeeRequest);
        Assert.assertNotNull(result);
    }

    @Test
    public void deleteEmployee() {
        employeeService.deleteEmployee(1L);
        verify(employeeGateway, Mockito.times(1)).deleteEmployee(1L);
    }
}