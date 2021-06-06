package com.service;

import static org.mockito.Mockito.when;

import com.gateway.PositionGateway;
import com.gateway.model.Position;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PositionServiceTest {

    @Mock
    private PositionGateway positionGateway;

    @InjectMocks
    private PositionServiceImpl positionServiceImpl;

    @Test
    public void getPositions() {
        List<Position> positions = Arrays.asList(new Position(1L, "name"));
        when(positionGateway.getPositions()).thenReturn(positions);
        List<Position> result = positionServiceImpl.getPositions();
        Assert.assertTrue(result.size() > 0);
    }
}