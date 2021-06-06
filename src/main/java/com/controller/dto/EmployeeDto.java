package com.controller.dto;

public class EmployeeDto {
    private Long id;
    private CandidateDto candidate;
    private PositionDto position;
    private float salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CandidateDto getCandidate() {
        return candidate;
    }

    public void setCandidate(CandidateDto candidate) {
        this.candidate = candidate;
    }

    public PositionDto getPosition() {
        return position;
    }

    public void setPosition(PositionDto position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
