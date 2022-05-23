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

    private BicycleDTO getDtoFromBicycle(Bicycle bicycle) {
        BicycleDTO bicycleDTO = new BicycleDTO();

        bicycleDTO.setId(bicycle.getId());
        bicycleDTO.setName(bicycle.getName());
        bicycleDTO.setShortDesc(bicycle.getShortDesc());
        bicycleDTO.setFullDesc(bicycle.getFullDesc());
        bicycleDTO.setFrameType(bicycle.getFrameType());
        bicycleDTO.setFrameSize(bicycle.getFrameSize());
        bicycleDTO.setWheelSize(bicycle.getWheelSize());
        bicycleDTO.setStyle(bicycle.getStyle());

        return bicycleDTO;
    }

    private Bicycle getBicycleFromDto(BicycleDTO bicycleDTO) {
        Bicycle bicycle = new Bicycle();

        bicycle.setName(bicycleDTO.getName());
        bicycle.setShortDesc(bicycleDTO.getShortDesc());
        bicycle.setFullDesc(bicycleDTO.getFullDesc());
        bicycle.setFrameType(bicycleDTO.getFrameType());
        bicycle.setFrameSize(bicycleDTO.getFrameSize());
        bicycle.setWheelSize(bicycleDTO.getWheelSize());
        bicycle.setStyle(bicycleDTO.getStyle());

        return bicycle;
    }

    private List<BicycleDTO> getDtoListFromBicycleList(List<Bicycle> bicycleList) {
        List<BicycleDTO> bicycleDTOList = new ArrayList<BicycleDTO>();
        bicycleList.forEach(bicycle -> {
            BicycleDTO bicycleDTO = getDtoFromBicycle(bicycle);
            bicycleDTOList.add(bicycleDTO);
        });
        return bicycleDTOList;
    }

    public List<BicycleDTO> getBicycles() {
        return getDtoListFromBicycleList(bicycleRepository.findAll());
    }

    public BicycleDTO getBicycle (Long id) {
        Bicycle bicycle = bicycleRepository.findById(id).orElseThrow(()-> new ProductNotFoundException());
        BicycleDTO bicycleDTO = getDtoFromBicycle(bicycle);
        return bicycleDTO;
    }

    public void addBicycle(BicycleDTO bicycleDTO) {
        Bicycle newBicycle = getBicycleFromDto(bicycleDTO);
        bicycleRepository.save(newBicycle);
    }

    public void updateBicycle(BicycleDTO bicycleDTO, Long id) {
        Bicycle updatedBicycle = getBicycleFromDto(bicycleDTO);
        updatedBicycle.setId(id);
        bicycleRepository.save(updatedBicycle);
    }

    public void deleteBicycle(Long id) throws ProductNotFoundException {
        bicycleRepository.delete(bicycleRepository.findById(id).orElseThrow(()-> new ProductNotFoundException()));
    }
}
