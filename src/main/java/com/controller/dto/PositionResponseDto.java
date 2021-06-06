package com.controller.dto;

import java.util.List;

public class PositionResponseDto {
    private long id;
    private String name;
    private List<EmployeeResponseDto> employee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeResponseDto> getEmployee() {
        return employee;
    }

    public void setEmployee(List<EmployeeResponseDto> employee) {
        this.employee = employee;
    }
}
