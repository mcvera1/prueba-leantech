package com.service;

import com.gateway.model.Candidate;
import com.gateway.model.Employee;
import com.gateway.model.Position;
import java.util.List;

public interface EmployeeService {
    void createEmployee(EmployeeRequest employeeRequest);

    List<Employee> getEmployee(String name, String position);

    Employee updateEmployee(EmployeeRequest request);

    void deleteEmployee(Long id);

    class EmployeeRequest {
        private long id;
        private Candidate candidate;
        private Position position;
        private float salary;

        public long getId() {
            return id;
        }

        public void setId(long id) {
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
}
