package com.gateway;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.exceptions.NotFoundException;
import com.gateway.model.Candidate;
import com.gateway.model.Employee;
import com.gateway.model.Position;
import com.gateway.repository.CandidateRepository;
import com.gateway.repository.EmployeeRepository;
import com.gateway.repository.PositionRepository;
import com.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeGatewayTest {

    @InjectMocks
    private EmployeeGatewayImpl employeeGateway;
    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void getEmployee() {
        List<Employee> result = Arrays.asList(new Employee(1L, new Candidate(1L, "name", "lastName", "address", 123L, "city"), new Position(1L, "namePosition"), 2.3F));
        when(employeeRepository.findAll()).thenReturn(result);
        List<Employee> getEmployee = employeeGateway.getEmployee(null, null);
        Assert.assertTrue(getEmployee.size() > 0);
    }

    @Test
    public void getEmployeeByEmployeeName() {
        List<Employee> result = Arrays.asList(new Employee(1L, new Candidate(1L, "name", "lastName", "address", 123L, "city"), new Position(1L, "namePosition"), 2.3F));
        when(employeeRepository.findAll()).thenReturn(result);
        List<Employee> getEmployee = employeeGateway.getEmployee("name", null);
        Assert.assertTrue(getEmployee.size() > 0);
    }

    @Test
    public void getEmployeeByEmployeePositionName() {
        List<Employee> result = Arrays.asList(new Employee(1L, new Candidate(1L, "name", "lastName", "address", 123L, "city"), new Position(1L, "namePosition"), 2.3F));
        when(employeeRepository.findAll()).thenReturn(result);
        List<Employee> getEmployee = employeeGateway.getEmployee(null, "namePosition");
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
        when( employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
        Employee result = employeeGateway.updateEmployee(employeeRequest);
        Assert.assertNotNull(result);
    }

    @Test
    public void deleteEmployee() {
        Employee employee = new Employee(1L, new Candidate(1L, "name", "lastName", "address", 123L, "city"), new Position(1L, "namePosition"), 2.3F);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        employeeGateway.deleteEmployee(1L);
        verify(employeeRepository, Mockito.times(1)).delete(employee);
    }

    @Test(expected = NotFoundException.class)
    public void deleteEmployeeNotFound() {
        Employee employee = new Employee(1L, new Candidate(1L, "name", "lastName", "address", 123L, "city"), new Position(1L, "namePosition"), 2.3F);
        when(employeeRepository.findById(2L)).thenReturn(Optional.of(employee));
        employeeGateway.deleteEmployee(1L);
        verify(employeeRepository, Mockito.times(1)).delete(employee);
    }
}