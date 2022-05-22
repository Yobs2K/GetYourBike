package com.example.labjava.service;

import com.example.labjava.dto.BicycleDTO;
import com.example.labjava.model.Bicycle;
import com.example.labjava.repository.BicycleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicycleService {

    private final BicycleRepository bicycleRepository;

    public BicycleService(BicycleRepository bicycleRepository) {
        this.bicycleRepository = bicycleRepository;
    }

    public List<Bicycle> getBicycles() {
        return bicycleRepository.findAll();
    }

    public Bicycle getBicycle (Long id) {
        return bicycleRepository.getById(id);
    }

    public void addBicycle(BicycleDTO bicycleDTO) {
        Bicycle newBicycle = new Bicycle();
        newBicycle.setName(bicycleDTO.getName());
        newBicycle.setShortDesc(bicycleDTO.getShortDesc());
        newBicycle.setFullDesc(bicycleDTO.getFullDesc());
        newBicycle.setFrameType(bicycleDTO.getFrameType());
        newBicycle.setFrameSize(bicycleDTO.getFrameSize());
        newBicycle.setStyle(bicycleDTO.getStyle());

        bicycleRepository.save(newBicycle);
    }

    public void updateBicycle(BicycleDTO bicycleDTO, Long id) {
        Bicycle updatedBicycle = bicycleRepository.getById(id);

        updatedBicycle.setName(bicycleDTO.getName());
        updatedBicycle.setShortDesc(bicycleDTO.getShortDesc());
        updatedBicycle.setFullDesc(bicycleDTO.getFullDesc());
        updatedBicycle.setFrameType(bicycleDTO.getFrameType());
        updatedBicycle.setFrameSize(bicycleDTO.getFrameSize());
        updatedBicycle.setStyle(bicycleDTO.getStyle());

        bicycleRepository.save(updatedBicycle);
    }

    public void deleteBicycle(Long id) {
        bicycleRepository.deleteById(id);
    }
}
