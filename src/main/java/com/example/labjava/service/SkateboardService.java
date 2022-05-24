package com.example.labjava.service;

import com.example.labjava.dto.SkateboardDTO;
import com.example.labjava.exception.ForeignKeyConstraintException;
import com.example.labjava.exception.ProductNotFoundException;
import com.example.labjava.model.Skateboard;
import com.example.labjava.model.Skatewheel;
import com.example.labjava.repository.SkateboardRepository;
import com.example.labjava.repository.SkatewheelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkateboardService {

    private final SkateboardRepository skateboardRepository;
    private final SkatewheelRepository skatewheelRepository;
    private final SkatewheelService skatewheelService;

    public SkateboardService(SkateboardRepository skateboardRepository, SkatewheelRepository skatewheelRepository, SkatewheelService skatewheelService) {
        this.skateboardRepository = skateboardRepository;
        this.skatewheelRepository = skatewheelRepository;
        this.skatewheelService = skatewheelService;
    }

    private SkateboardDTO getDtoFromSkateboard(Skateboard skateboard) {
        SkateboardDTO skateboardDTO = new SkateboardDTO();

        skateboardDTO.setId(skateboard.getId());
        skateboardDTO.setName(skateboard.getName());
        skateboardDTO.setShortDesc(skateboard.getShortDesc());
        skateboardDTO.setFullDesc(skateboard.getFullDesc());
        skateboardDTO.setWidth(skateboard.getWidth());
        skateboardDTO.setLength(skateboard.getLength());
        skateboardDTO.setSuspensionWidth(skateboard.getSuspensionWidth());
        skateboardDTO.setImgLink(skateboard.getImgLink());
        skateboardDTO.setSkatewheelId(skateboard.getSkateWheel().getId());
        skateboardDTO.setSkatewheel(skatewheelService.getDtoFromSkatewheel(skateboard.getSkateWheel()));

        return skateboardDTO;
    }

    private Skateboard getSkateboardFromDto(SkateboardDTO skateboardDTO) {
        Skateboard skateboard = new Skateboard();

        skateboard.setName(skateboardDTO.getName());
        skateboard.setShortDesc(skateboardDTO.getShortDesc());
        skateboard.setFullDesc(skateboardDTO.getFullDesc());
        skateboard.setWidth(skateboardDTO.getWidth());
        skateboard.setLength(skateboardDTO.getLength());
        skateboard.setSuspensionWidth(skateboardDTO.getSuspensionWidth());
        skateboard.setImgLink(skateboardDTO.getImgLink());
        Skatewheel skatewheel = skatewheelRepository.findById(skateboardDTO.getSkatewheelId()).
                orElseThrow(() -> new ForeignKeyConstraintException());
        skateboard.setSkateWheel(skatewheel);

        return skateboard;
    }

    private List<SkateboardDTO> getDtoListFromSkateboardList(List<Skateboard> skateboardList) {
        List<SkateboardDTO> skateboardDTOList = new ArrayList<SkateboardDTO>();
        skateboardList.forEach(skateboard -> {
            SkateboardDTO skateboardDTO = getDtoFromSkateboard(skateboard);
            skateboardDTOList.add(skateboardDTO);
        });
        return skateboardDTOList;
    }

    public List<SkateboardDTO> getSkateboards() {
        return getDtoListFromSkateboardList(skateboardRepository.findAll());
    }

    public SkateboardDTO getSkateboard (Long id) {
        Skateboard skateboard = skateboardRepository.findById(id).orElseThrow(()-> new ProductNotFoundException());
        SkateboardDTO skateboardDTO = getDtoFromSkateboard(skateboard);
        return skateboardDTO;
    }

    public void addSkateboard(SkateboardDTO skateboardDTO) {
        Skateboard newSkateboard = getSkateboardFromDto(skateboardDTO);
        skateboardRepository.save(newSkateboard);
    }

    public void updateSkateboard(SkateboardDTO skateboardDTO, Long id) {
        Skateboard updatedSkateboard = getSkateboardFromDto(skateboardDTO);
        updatedSkateboard.setId(id);
        skateboardRepository.save(updatedSkateboard);
    }

    public void deleteSkateboard(Long id) throws ProductNotFoundException {
        Skateboard skateboard = skateboardRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());
        skateboard.setSkateWheel(null);
        skateboardRepository.delete(skateboard);
    }
}
