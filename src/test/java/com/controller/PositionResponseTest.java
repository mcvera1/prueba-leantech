package com.controller;

import com.controller.dto.PositionResponseDto;
import com.gateway.model.Candidate;
import com.gateway.model.Employee;
import com.gateway.model.Position;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PositionResponseTest {

    @Test
    public void fromModel() {
        Position position = new Position();
        position.setId(1L);
        position.setName("name");
        position.setEmployee(Arrays.asList(new Employee(1L, new Candidate(1L, "name", "lastName", "address", 123L, "city"), new Position(1L, "namePosition"), 2.3F)));
        List<Position> positions = Arrays.asList(position);
        List<PositionResponseDto> result = PositionResponse.fromModel(positions);
        Assert.assertTrue(result.size() > 0);
    }
}