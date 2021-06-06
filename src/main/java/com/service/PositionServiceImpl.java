package com.service;

import com.gateway.PositionGateway;
import com.gateway.model.Position;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{

    private PositionGateway positionGateway;

    public PositionServiceImpl(PositionGateway positionGateway) {
        this.positionGateway = positionGateway;
    }

    @Override
    public List<Position> getPositions() {
        return positionGateway.getPositions();
    }
}
