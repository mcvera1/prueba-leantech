package com.controller;

import com.controller.dto.CandidateDto;
import com.controller.dto.EmployeeDto;
import com.controller.dto.PositionDto;
import com.gateway.model.Employee;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeResponse {

    private List<EmployeeDto> employeeDto;

    public static List<EmployeeDto> fromModel(List<Employee> employeeList) {

        List<EmployeeDto> result =  employeeList.stream().map(employee -> {

            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());

            CandidateDto candidate = new CandidateDto();
            candidate.setId(employee.getCandidate().getId());
            candidate.setName(employee.getCandidate().getName());
            candidate.setLastName(employee.getCandidate().getLastName());
            candidate.setCellphone(employee.getCandidate().getCellphone());
            candidate.setAddress(employee.getCandidate().getAddress());
            candidate.setCityName(employee.getCandidate().getCityName());
            employeeDto.setCandidate(candidate);

            PositionDto position = new PositionDto();
            position.setId(employee.getPosition().getId());
            position.setName(employee.getPosition().getName());
            employeeDto.setPosition(position);

            employeeDto.setSalary(employee.getSalary());
            return employeeDto;
        }).collect(Collectors.toList());
        return result;
    }
}
