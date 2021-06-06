package com.gateway;

import static org.mockito.Mockito.*;

import com.gateway.model.Position;
import com.gateway.repository.PositionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PositionGatewayTest {

    @InjectMocks
    private PositionGatewayImpl positionGatewayImpl;

    @Mock
    private PositionRepository positionRepository;

    @Test
    public void getPositions() {
        List<Position> positions = Arrays.asList(new Position(1L, "name"));
        when(positionRepository.findAll()).thenReturn(positions);
        List<Position> result = positionGatewayImpl.getPositions();
        Assert.assertTrue(result.size() > 0);
    }
}