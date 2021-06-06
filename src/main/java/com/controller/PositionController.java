package com.controller;

import com.controller.dto.PositionResponseDto;
import com.service.PositionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class PositionController {

    private PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/get/positions")
    public List<PositionResponseDto> getEmployee() {
        return PositionResponse.fromModel(positionService.getPositions());
    }
}
