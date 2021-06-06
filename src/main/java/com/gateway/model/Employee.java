package com.gateway.model;

import javax.persistence.*;


@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Candidate candidate;
    @ManyToOne
    private Position position;
    private float salary;

    public Employee(){}

    public Employee(Long id, Candidate candidate, Position position, float salary) {
        this.id = id;
        this.candidate = candidate;
        this.position = position;
        this.salary = salary;
    }

    public Employee(Candidate candidate, Position position, float salary) {
        this.candidate = candidate;
        this.position = position;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
