package com.controller;

import com.controller.dto.CandidateDto;
import com.controller.dto.EmployeeResponseDto;
import com.controller.dto.PositionResponseDto;
import com.gateway.model.Employee;
import com.gateway.model.Position;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PositionResponse {

    private List<PositionResponseDto> positionDto;

    public static List<PositionResponseDto> fromModel(List<Position> positions) {
        List<PositionResponseDto> result = positions.stream().map(position -> {
            PositionResponseDto positionDto = new PositionResponseDto();
            positionDto.setId(position.getId());
            positionDto.setName(position.getName());
            List<EmployeeResponseDto> listEmployeeDto = position.getEmployee().stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).map(employee -> {
                EmployeeResponseDto employeeDto = new EmployeeResponseDto();
                employeeDto.setSalary(employee.getSalary());
                employeeDto.setId(employee.getId());
                CandidateDto candidate = new CandidateDto();
                candidate.setName(employee.getCandidate().getName());
                candidate.setLastName(employee.getCandidate().getLastName());
                candidate.setCellphone(employee.getCandidate().getCellphone());
                candidate.setAddress(employee.getCandidate().getAddress());
                candidate.setCityName(employee.getCandidate().getCityName());
                employeeDto.setCandidate(candidate);
                return employeeDto;
            }).collect(Collectors.toList());
            positionDto.setEmployee(listEmployeeDto);
            return positionDto;
        }).collect(Collectors.toList());

        return result;
    }
}
