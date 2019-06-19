package com.iyteemlak.api.service;

import com.iyteemlak.api.entity.House;
import com.iyteemlak.api.model.dto.HouseDTO;
import com.iyteemlak.api.model.dto.LatLngDTO;
import com.iyteemlak.api.model.request.AddHouseRequest;
import com.iyteemlak.api.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<HouseDTO> getAllHouses() {
        return houseRepository.getActiveHouses().stream().map(house -> {
            LatLngDTO latLngDTO = new LatLngDTO();
            latLngDTO.setLat(house.getLat());
            latLngDTO.setLng(house.getLng());

            HouseDTO houseDTO = new HouseDTO();
            houseDTO.setId(house.getId());
            houseDTO.setRooms(house.getRooms());
            houseDTO.setPrice(house.getPrice());
            houseDTO.setContact(house.getContact());
            houseDTO.setDescription(house.getDescription());
            houseDTO.setLocation(latLngDTO);
            return houseDTO;
        }).collect(Collectors.toList());
    }

    public void addHouse(AddHouseRequest addHouseRequest) {
        House house = new House();
        house.setRooms(addHouseRequest.getRooms());
        house.setPrice(addHouseRequest.getPrice());
        house.setContact(addHouseRequest.getContact());
        house.setDescription(addHouseRequest.getDescription());
        house.setLat(addHouseRequest.getLocation().getLat());
        house.setLng(addHouseRequest.getLocation().getLng());
        house.setActive(false);
        houseRepository.save(house);
    }

}
