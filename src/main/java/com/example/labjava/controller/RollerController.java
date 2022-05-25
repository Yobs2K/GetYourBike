package com.example.labjava.controller;

import com.example.labjava.dto.RollerDTO;
import com.example.labjava.exception.ProductNotFoundException;
import com.example.labjava.service.RollerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/rollers")
public class RollerController {

    private final RollerService rollerService;

    @Autowired
    public RollerController(RollerService rollerService) {
        this.rollerService = rollerService;
    }

    @GetMapping
    public ResponseEntity<List<RollerDTO>> getAllRollers() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok().
                headers(httpHeaders).
                body(rollerService.getRollers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RollerDTO> getRollerById(@PathVariable("id") final Long id) {
        RollerDTO rollerDTO;
        try {
            rollerDTO = rollerService.getRoller(id);
        }
        catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(rollerDTO);
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deleteRoller(@PathVariable("id") final Long id) {
        try {
            rollerService.deleteRoller(id);
        }
        catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return HttpStatus.OK;
    }

    @PostMapping
    public HttpStatus addRoller(@RequestBody RollerDTO newRoller) {
        rollerService.addRoller(newRoller);
        return HttpStatus.CREATED;
    }

    @PutMapping(value = "/{id}")
    public HttpStatus updateRoller(@RequestBody RollerDTO newRoller, @PathVariable("id") final Long id) {
        try {
            rollerService.updateRoller(newRoller, id);
        }
        catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return HttpStatus.CREATED;
    }
}
