package com.config;

import com.gateway.EmployeeGatewayImpl;
import com.gateway.PositionGatewayImpl;
import com.gateway.repository.CandidateRepository;
import com.gateway.repository.EmployeeRepository;
import com.gateway.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PositionRepository positionRepository;

    public EmployeeGatewayImpl employeeGatewayImpl(){
        return new EmployeeGatewayImpl(employeeRepository, candidateRepository, positionRepository);
    }

    public PositionGatewayImpl positionGatewayImpl() {
        return new PositionGatewayImpl(positionRepository);
    }
}
