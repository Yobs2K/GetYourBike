package com.example.labjava.service;

import com.example.labjava.dto.BicycleDTO;
import com.example.labjava.exception.ProductNotFoundException;
import com.example.labjava.model.Bicycle;
import com.example.labjava.repository.BicycleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BicycleService {

    private final BicycleRepository bicycleRepository;

    public BicycleService(BicycleRepository bicycleRepository) {
        this.bicycleRepository = bicycleRepository;
    }

    private List<BicycleDTO> getDtoListFromBicycleList(List<Bicycle> bicycleList) {
        List<BicycleDTO> bicycleDTOList = new ArrayList<BicycleDTO>();
        bicycleList.forEach(bicycle -> {
            BicycleDTO bicycleDTO = new BicycleDTO();

            bicycleDTO.setName(bicycle.getName());
            bicycleDTO.setShortDesc(bicycle.getShortDesc());
            bicycleDTO.setFullDesc(bicycle.getFullDesc());
            bicycleDTO.setFrameType(bicycle.getFrameType());
            bicycleDTO.setFrameSize(bicycle.getFrameSize());
            bicycleDTO.setStyle(bicycle.getStyle());

            bicycleDTOList.add(bicycleDTO);
        });
        return bicycleDTOList;
    }

    public List<BicycleDTO> getBicycles() {
        return getDtoListFromBicycleList(bicycleRepository.findAll());
    }

    public BicycleDTO getBicycle (Long id) {
        Bicycle bicycle = bicycleRepository.findById(id).orElseThrow(()-> new ProductNotFoundException());
        BicycleDTO bicycleDTO = new BicycleDTO();

        bicycleDTO.setName(bicycle.getName());
        bicycleDTO.setShortDesc(bicycle.getShortDesc());
        bicycleDTO.setFullDesc(bicycle.getFullDesc());
        bicycleDTO.setFrameType(bicycle.getFrameType());
        bicycleDTO.setFrameSize(bicycle.getFrameSize());
        bicycleDTO.setStyle(bicycle.getStyle());

        return bicycleDTO;
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
        Bicycle updatedBicycle = bicycleRepository.findById(id).orElseThrow(()-> new ProductNotFoundException());

        updatedBicycle.setName(bicycleDTO.getName());
        updatedBicycle.setShortDesc(bicycleDTO.getShortDesc());
        updatedBicycle.setFullDesc(bicycleDTO.getFullDesc());
        updatedBicycle.setFrameType(bicycleDTO.getFrameType());
        updatedBicycle.setFrameSize(bicycleDTO.getFrameSize());
        updatedBicycle.setStyle(bicycleDTO.getStyle());

        bicycleRepository.save(updatedBicycle);
    }

    public void deleteBicycle(Long id) throws ProductNotFoundException {
        bicycleRepository.delete(bicycleRepository.findById(id).orElseThrow(()-> new ProductNotFoundException()));
    }
}
