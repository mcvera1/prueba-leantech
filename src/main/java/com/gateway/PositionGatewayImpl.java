package com.gateway;

import com.gateway.model.Position;
import com.gateway.repository.PositionRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PositionGatewayImpl implements PositionGateway{

    private PositionRepository positionRepository;

    public PositionGatewayImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> getPositions() {
        return (List<Position>)positionRepository.findAll();
    }
}
