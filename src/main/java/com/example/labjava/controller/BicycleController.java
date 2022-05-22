package com.example.labjava.controller;

import com.example.labjava.dto.BicycleDTO;
import com.example.labjava.model.Bicycle;
import com.example.labjava.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bicycles")
public class BicycleController {

    private final BicycleService bicycleService;

    @Autowired
    public BicycleController(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    @GetMapping
    public List<Bicycle> getAllBicycles() {
        return bicycleService.getBicycles();
    }

    @GetMapping(value = "/{id}")
    public Bicycle getBicycleById(@PathVariable("id") final Long id) {
        return bicycleService.getBicycle(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBicycle(@PathVariable("id") final Long id) {
        bicycleService.deleteBicycle(id);
    }

    @PostMapping
    public void addBicycle(@RequestBody BicycleDTO newBicycle) {
        bicycleService.addBicycle(newBicycle);
    }

    @PutMapping(value = "/{id}")
    public void updateBicycle(@RequestBody BicycleDTO newBicycle, @PathVariable("id") final Long id) {
        bicycleService.updateBicycle(newBicycle, id);
    }
}
