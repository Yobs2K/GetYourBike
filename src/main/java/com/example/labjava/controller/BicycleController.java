package com.example.labjava.controller;

import com.example.labjava.dto.BicycleDTO;
import com.example.labjava.exception.ProductNotFoundException;
import com.example.labjava.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<List<BicycleDTO>> getAllBicycles(@RequestParam(name = "style", required = false) String style) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        if (style == null)
            return ResponseEntity.ok().
                    headers(httpHeaders).
                    body(bicycleService.getBicycles());
        return ResponseEntity.ok().
                headers(httpHeaders).
                body(bicycleService.getBicyclesByStyle(style));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<BicycleDTO> getBicycleById(@PathVariable("id") final Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        BicycleDTO bicycleDTO;
        try {
            bicycleDTO = bicycleService.getBicycle(id);
        }
        catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().
                headers(httpHeaders).
                body(bicycleDTO);
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deleteBicycle(@PathVariable("id") final Long id) {
        try {
            bicycleService.deleteBicycle(id);
        }
        catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return HttpStatus.OK;
    }

    @PostMapping
    public HttpStatus addBicycle(@RequestBody BicycleDTO newBicycle) {
        bicycleService.addBicycle(newBicycle);
        return HttpStatus.CREATED;
    }

    @PutMapping(value = "/{id}")
    public HttpStatus updateBicycle(@RequestBody BicycleDTO newBicycle, @PathVariable("id") final Long id) {
        try {
            bicycleService.updateBicycle(newBicycle, id);
        }
        catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return HttpStatus.CREATED;
    }
}
