package com.example.labjava.controller;

import com.example.labjava.dto.SkateboardDTO;
import com.example.labjava.exception.ForeignKeyConstraintException;
import com.example.labjava.exception.ProductNotFoundException;
import com.example.labjava.service.SkateboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/skateboards")
public class SkateboardController {

    private final SkateboardService skateboardService;

    @Autowired
    public SkateboardController(SkateboardService skateboardService) {
        this.skateboardService = skateboardService;
    }

    @GetMapping
    public List<SkateboardDTO> getAllSkateboards() {
        return skateboardService.getSkateboards();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SkateboardDTO> getSkateboardById(@PathVariable("id") final Long id) {
        SkateboardDTO skateboardDTO;
        try {
            skateboardDTO = skateboardService.getSkateboard(id);
        }
        catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(skateboardDTO);
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deleteSkateboard(@PathVariable("id") final Long id) {
        try {
            skateboardService.deleteSkateboard(id);
        }
        catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        catch (ForeignKeyConstraintException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return HttpStatus.OK;
    }

    @PostMapping
    public HttpStatus addSkateboard(@RequestBody SkateboardDTO newSkateboard) {
        try {
            skateboardService.addSkateboard(newSkateboard);
        }
        catch (ForeignKeyConstraintException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return HttpStatus.CREATED;
    }

    @PutMapping(value = "/{id}")
    public HttpStatus updateSkateboard(@RequestBody SkateboardDTO newSkateboard, @PathVariable("id") final Long id) {
        try {
            skateboardService.updateSkateboard(newSkateboard, id);
        }
        catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        catch (ForeignKeyConstraintException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return HttpStatus.CREATED;
    }
}
