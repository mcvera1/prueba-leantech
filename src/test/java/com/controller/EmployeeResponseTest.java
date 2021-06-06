package com.controller;

import com.controller.dto.EmployeeDto;
import com.gateway.model.Candidate;
import com.gateway.model.Employee;
import com.gateway.model.Position;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeResponseTest {

    @Test
    public void fromModel() {
        List<Employee> employees = Arrays.asList(new Employee(1L, new Candidate(1L, "name", "lastName", "address", 123L, "city"), new Position(1L, "namePosition"), 2.3F));
        List<EmployeeDto> result = EmployeeResponse.fromModel(employees);
        Assert.assertTrue(result.size() > 0);
    }
}