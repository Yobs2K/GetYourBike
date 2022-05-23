package com.example.labjava.service;

import com.example.labjava.dto.SkatewheelDTO;
import com.example.labjava.exception.ForeignKeyConstraintException;
import com.example.labjava.exception.ProductNotFoundException;
import com.example.labjava.model.Skatewheel;
import com.example.labjava.repository.SkatewheelRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkatewheelService {

    private final SkatewheelRepository skatewheelRepository;

    public SkatewheelService(SkatewheelRepository skatewheelRepository) {
        this.skatewheelRepository = skatewheelRepository;
    }

    public SkatewheelDTO getDtoFromSkatewheel(Skatewheel skatewheel) {
        SkatewheelDTO skatewheelDTO = new SkatewheelDTO();

        skatewheelDTO.setId(skatewheel.getId());
        skatewheelDTO.setName(skatewheel.getName());
        skatewheelDTO.setShortDesc(skatewheel.getShortDesc());
        skatewheelDTO.setFullDesc(skatewheel.getFullDesc());
        skatewheelDTO.setWheelSize(skatewheel.getWheelSize());
        skatewheelDTO.setWheelHardness(skatewheel.getWheelHardness());

        return skatewheelDTO;
    }

    private Skatewheel getSkatewheelFromDto(SkatewheelDTO skatewheelDTO) {
        Skatewheel skatewheel = new Skatewheel();

        skatewheel.setName(skatewheelDTO.getName());
        skatewheel.setShortDesc(skatewheelDTO.getShortDesc());
        skatewheel.setFullDesc(skatewheelDTO.getFullDesc());
        skatewheel.setWheelSize(skatewheelDTO.getWheelSize());
        skatewheel.setWheelHardness(skatewheelDTO.getWheelHardness());

        return skatewheel;
    }

    private List<SkatewheelDTO> getDtoListFromSkatewheelList(List<Skatewheel> skatewheelList) {
        List<SkatewheelDTO> skatewheelDTOList = new ArrayList<SkatewheelDTO>();
        skatewheelList.forEach(skatewheel -> {
            SkatewheelDTO skatewheelDTO = getDtoFromSkatewheel(skatewheel);
            skatewheelDTOList.add(skatewheelDTO);
        });
        return skatewheelDTOList;
    }

    public List<SkatewheelDTO> getSkatewheels() {
        return getDtoListFromSkatewheelList(skatewheelRepository.findAll());
    }

    public SkatewheelDTO getSkatewheel (Long id) {
        Skatewheel skatewheel = skatewheelRepository.findById(id).orElseThrow(()-> new ProductNotFoundException());
        SkatewheelDTO skatewheelDTO = getDtoFromSkatewheel(skatewheel);
        return skatewheelDTO;
    }

    public void addSkatewheel(SkatewheelDTO skatewheelDTO) {
        Skatewheel newSkatewheel = getSkatewheelFromDto(skatewheelDTO);
        skatewheelRepository.save(newSkatewheel);
    }

    public void updateSkatewheel(SkatewheelDTO skatewheelDTO, Long id) {
        Skatewheel updatedSkatewheel = getSkatewheelFromDto(skatewheelDTO);
        updatedSkatewheel.setId(id);
        skatewheelRepository.save(updatedSkatewheel);
    }

    public void deleteSkatewheel(Long id) throws ProductNotFoundException {
        try {
            skatewheelRepository.delete(skatewheelRepository.findById(id).orElseThrow(() -> new ProductNotFoundException()));
        }
        catch (DataIntegrityViolationException e) {
            throw new ForeignKeyConstraintException();
        }
    }
}
