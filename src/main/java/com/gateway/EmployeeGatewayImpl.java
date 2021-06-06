package com.gateway;

import com.exceptions.NotFoundException;
import com.gateway.model.Candidate;
import com.gateway.model.Employee;
import com.gateway.model.Position;
import com.gateway.repository.CandidateRepository;
import com.gateway.repository.EmployeeRepository;
import com.gateway.repository.PositionRepository;
import com.service.EmployeeService;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeGatewayImpl implements EmployeeGateway {

    private EmployeeRepository employeeRepository;
    private CandidateRepository candidateRepository;
    private PositionRepository positionRepository;

    public EmployeeGatewayImpl(EmployeeRepository employeeRepository, CandidateRepository candidateRepository, PositionRepository positionRepository) {
        this.employeeRepository = employeeRepository;
        this.candidateRepository = candidateRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public void createEmployee(EmployeeService.EmployeeRequest employeeRequest) {
        candidateRepository.save(new Candidate(employeeRequest.getCandidate().getId(), employeeRequest.getCandidate().getName(), employeeRequest.getCandidate().getLastName(), employeeRequest.getCandidate().getAddress(), employeeRequest.getCandidate().getCellphone(), employeeRequest.getCandidate().getCityName()));
        positionRepository.save(new Position(employeeRequest.getPosition().getId(), employeeRequest.getPosition().getName()));
        employeeRepository.save(new Employee(employeeRequest.getCandidate(), employeeRequest.getPosition(), employeeRequest.getSalary()));
    }

    @Override
    public List<Employee> getEmployee(String name, String position) {
        List<Employee> result = (List<Employee>) employeeRepository.findAll();
        List<Employee> resultEmployee = null;
        if(Objects.nonNull(name)) {
            resultEmployee = result.stream().filter(employee -> employee.getCandidate().getName().equals(name)).collect(Collectors.toList());
        } else if(Objects.nonNull((position))) {
            resultEmployee = result.stream().filter(employee -> employee.getPosition().getName().equals(position)).collect(Collectors.toList());
        }
        return Objects.nonNull(resultEmployee)?resultEmployee:result;
    }

    @Override
    public Employee updateEmployee(EmployeeService.EmployeeRequest request) {
        Optional<Employee> employee = employeeRepository.findById(request.getId());
        Employee employeeReponse = null;
        if (employee.isPresent()) {
            employeeReponse = new Employee(request.getId(), request.getCandidate(), request.getPosition(), request.getSalary());
            candidateRepository.save(new Candidate(employeeReponse.getCandidate().getId(), employeeReponse.getCandidate().getName(), employeeReponse.getCandidate().getLastName(), employeeReponse.getCandidate().getAddress(), employeeReponse.getCandidate().getCellphone(), employeeReponse.getCandidate().getCityName()));
            positionRepository.save(new Position(employeeReponse.getPosition().getId(), employeeReponse.getPosition().getName()));
            employeeRepository.save(employeeReponse);
        } else {
            throw new NotFoundException("Employee not found");
        }
        return employeeReponse;
    }

    @Override
    public void deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.delete(employee.get());
        } else {
            throw new NotFoundException("Employee not found");
        }
    }
}
