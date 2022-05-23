package com.example.labjava.service;

import com.example.labjava.dto.SkatewheelDTO;
import com.example.labjava.exception.ProductNotFoundException;
import com.example.labjava.model.Skatewheel;
import com.example.labjava.repository.SkatewheelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkatewheelService {

    private final SkatewheelRepository skatewheelRepository;

    public SkatewheelService(SkatewheelRepository skatewheelRepository) {
        this.skatewheelRepository = skatewheelRepository;
    }

    private List<SkatewheelDTO> getDtoListFromSkatewheelList(List<Skatewheel> skatewheelList) {
        List<SkatewheelDTO> skatewheelDTOList = new ArrayList<SkatewheelDTO>();
        skatewheelList.forEach(skatewheel -> {
            SkatewheelDTO skatewheelDTO = new SkatewheelDTO();

            skatewheelDTO.setName(skatewheel.getName());
            skatewheelDTO.setShortDesc(skatewheel.getShortDesc());
            skatewheelDTO.setFullDesc(skatewheel.getFullDesc());
            skatewheelDTO.setWheelSize(skatewheel.getWheelSize());
            skatewheelDTO.setWheelHardness(skatewheel.getWheelHardness());
            skatewheelDTOList.add(skatewheelDTO);
        });
        return skatewheelDTOList;
    }

    public List<SkatewheelDTO> getSkatewheels() {
        return getDtoListFromSkatewheelList(skatewheelRepository.findAll());
    }

    public SkatewheelDTO getSkatewheel (Long id) {
        Skatewheel skatewheel = skatewheelRepository.findById(id).orElseThrow(()-> new ProductNotFoundException());
        SkatewheelDTO skatewheelDTO = new SkatewheelDTO();

        skatewheelDTO.setName(skatewheel.getName());
        skatewheelDTO.setShortDesc(skatewheel.getShortDesc());
        skatewheelDTO.setFullDesc(skatewheel.getFullDesc());
        skatewheelDTO.setWheelSize(skatewheel.getWheelSize());
        skatewheelDTO.setWheelHardness(skatewheel.getWheelHardness());

        return skatewheelDTO;
    }

    public void addSkatewheel(SkatewheelDTO skatewheelDTO) {
        Skatewheel newSkatewheel = new Skatewheel();

        newSkatewheel.setName(skatewheelDTO.getName());
        newSkatewheel.setShortDesc(skatewheelDTO.getShortDesc());
        newSkatewheel.setFullDesc(skatewheelDTO.getFullDesc());
        newSkatewheel.setWheelSize(skatewheelDTO.getWheelSize());
        newSkatewheel.setWheelHardness(skatewheelDTO.getWheelHardness());


        skatewheelRepository.save(newSkatewheel);
    }

    public void updateSkatewheel(SkatewheelDTO skatewheelDTO, Long id) {
        Skatewheel updatedSkatewheel = skatewheelRepository.findById(id).orElseThrow(()-> new ProductNotFoundException());

        updatedSkatewheel.setName(skatewheelDTO.getName());
        updatedSkatewheel.setShortDesc(skatewheelDTO.getShortDesc());
        updatedSkatewheel.setFullDesc(skatewheelDTO.getFullDesc());
        updatedSkatewheel.setWheelSize(skatewheelDTO.getWheelSize());
        updatedSkatewheel.setWheelHardness(skatewheelDTO.getWheelHardness());

        skatewheelRepository.save(updatedSkatewheel);
    }

    public void deleteSkatewheel(Long id) throws ProductNotFoundException {
        skatewheelRepository.delete(skatewheelRepository.findById(id).orElseThrow(()-> new ProductNotFoundException()));
    }
}
