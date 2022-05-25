package com.example.labjava.controller;

import com.example.labjava.dto.RollerDTO;
import com.example.labjava.service.BicycleService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BicycleStylesController {

    private final BicycleService bicycleService;

    public BicycleStylesController(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    @GetMapping("/bicycles/styles")
    public ResponseEntity<List<String>> getAllStyles() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok().
                headers(httpHeaders).
                body(bicycleService.getBicycleStyles());
    }
}
