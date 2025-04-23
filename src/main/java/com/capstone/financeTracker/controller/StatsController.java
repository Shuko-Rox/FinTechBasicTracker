package com.capstone.financeTracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.financeTracker.dto.GraphDTO;
import com.capstone.financeTracker.service.stats.StatsService;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin("*")
public class StatsController {

    private final StatsService statsService;

    // Manual constructor for dependency injection
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/chart")
    public ResponseEntity<GraphDTO> getChartDetails() {
        return ResponseEntity.ok(statsService.getChartData());
    }
    
    @GetMapping
    public ResponseEntity<?> getStats(){
    	return ResponseEntity.ok(statsService.getStats());
    }
}
