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

    private List<RollerDTO> getDtoListFromRollerList(List<Roller> rollerList) {
        List<RollerDTO> rollerDTOList = new ArrayList<RollerDTO>();
        rollerList.forEach(roller -> {
            RollerDTO rollerDTO = new RollerDTO();

            rollerDTO.setName(roller.getName());
            rollerDTO.setShortDesc(roller.getShortDesc());
            rollerDTO.setFullDesc(roller.getFullDesc());
            rollerDTO.setSize(roller.getSize());
            rollerDTO.setWheelSize(roller.getWheelSize());
            rollerDTO.setWheelNum(roller.getWheelNum());
            rollerDTO.setAge(roller.getAge());
            rollerDTO.setSex(roller.getSex());
            rollerDTO.setColor(roller.getColor());

            rollerDTOList.add(rollerDTO);
        });
        return rollerDTOList;
    }

    public List<RollerDTO> getRollers() {
        return getDtoListFromRollerList(rollerRepository.findAll());
    }

    public RollerDTO getRoller (Long id) {
        Roller roller = rollerRepository.findById(id).orElseThrow(()-> new ProductNotFoundException());
        RollerDTO rollerDTO = new RollerDTO();

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

    public void addRoller(RollerDTO rollerDTO) {
        Roller newRoller = new Roller();

        newRoller.setName(rollerDTO.getName());
        newRoller.setShortDesc(rollerDTO.getShortDesc());
        newRoller.setFullDesc(rollerDTO.getFullDesc());
        newRoller.setSize(rollerDTO.getSize());
        newRoller.setWheelSize(rollerDTO.getWheelSize());
        newRoller.setWheelNum(rollerDTO.getWheelNum());
        newRoller.setAge(rollerDTO.getAge());
        newRoller.setSex(rollerDTO.getSex());
        newRoller.setColor(rollerDTO.getColor());


        rollerRepository.save(newRoller);
    }

    public void updateRoller(RollerDTO rollerDTO, Long id) {
        Roller updatedRoller = rollerRepository.findById(id).orElseThrow(()-> new ProductNotFoundException());

        updatedRoller.setName(rollerDTO.getName());
        updatedRoller.setShortDesc(rollerDTO.getShortDesc());
        updatedRoller.setFullDesc(rollerDTO.getFullDesc());
        updatedRoller.setSize(rollerDTO.getSize());
        updatedRoller.setWheelSize(rollerDTO.getWheelSize());
        updatedRoller.setWheelNum(rollerDTO.getWheelNum());
        updatedRoller.setAge(rollerDTO.getAge());
        updatedRoller.setSex(rollerDTO.getSex());
        updatedRoller.setColor(rollerDTO.getColor());

        rollerRepository.save(updatedRoller);
    }

    public void deleteRoller(Long id) throws ProductNotFoundException {
        rollerRepository.delete(rollerRepository.findById(id).orElseThrow(()-> new ProductNotFoundException()));
    }
}
