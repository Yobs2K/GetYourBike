package com.example.labjava.service;

import com.example.labjava.dto.RollerDTO;
import com.example.labjava.exception.ProductNotFoundException;
import com.example.labjava.model.Roller;
import com.example.labjava.repository.RollerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RollerService {

    private final RollerRepository rollerRepository;

    public RollerService(RollerRepository rollerRepository) {
        this.rollerRepository = rollerRepository;
    }

    private RollerDTO getDtoFromRoller(Roller roller) {
        RollerDTO rollerDTO = new RollerDTO();

        rollerDTO.setId(roller.getId());
        rollerDTO.setName(roller.getName());
        rollerDTO.setShortDesc(roller.getShortDesc());
        rollerDTO.setFullDesc(roller.getFullDesc());
        rollerDTO.setSize(roller.getSize());
        rollerDTO.setWheelSize(roller.getWheelSize());
        rollerDTO.setWheelNum(roller.getWheelNum());
        rollerDTO.setAge(roller.getAge());
        rollerDTO.setSex(roller.getSex());
        rollerDTO.setColor(roller.getColor());

        return rollerDTO;
    }

    private Roller getRollerFromDto(RollerDTO rollerDTO) {
        Roller roller = new Roller();

        roller.setName(rollerDTO.getName());
        roller.setShortDesc(rollerDTO.getShortDesc());
        roller.setFullDesc(rollerDTO.getFullDesc());
        roller.setSize(rollerDTO.getSize());
        roller.setWheelSize(rollerDTO.getWheelSize());
        roller.setWheelNum(rollerDTO.getWheelNum());
        roller.setAge(rollerDTO.getAge());
        roller.setSex(rollerDTO.getSex());
        roller.setColor(rollerDTO.getColor());

        return roller;
    }

    private List<RollerDTO> getDtoListFromRollerList(List<Roller> rollerList) {
        List<RollerDTO> rollerDTOList = new ArrayList<RollerDTO>();
        rollerList.forEach(roller -> {
            RollerDTO rollerDTO = getDtoFromRoller(roller);
            rollerDTOList.add(rollerDTO);
        });
        return rollerDTOList;
    }

    public List<RollerDTO> getRollers() {
        return getDtoListFromRollerList(rollerRepository.findAll());
    }

    public RollerDTO getRoller (Long id) {
        Roller roller = rollerRepository.findById(id).orElseThrow(()-> new ProductNotFoundException());
        RollerDTO rollerDTO = getDtoFromRoller(roller);
        return rollerDTO;
    }

    public void addRoller(RollerDTO rollerDTO) {
        Roller newRoller = getRollerFromDto(rollerDTO);
        rollerRepository.save(newRoller);
    }

    public void updateRoller(RollerDTO rollerDTO, Long id) {
        Roller updatedRoller = getRollerFromDto(rollerDTO);
        updatedRoller.setId(id);
        rollerRepository.save(updatedRoller);
    }

    public void deleteRoller(Long id) throws ProductNotFoundException {
        rollerRepository.delete(rollerRepository.findById(id).orElseThrow(()-> new ProductNotFoundException()));
    }
}
