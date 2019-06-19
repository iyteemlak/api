package com.iyteemlak.api.service;

import com.iyteemlak.api.model.dto.HouseDTO;
import com.iyteemlak.api.model.request.AddHouseRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HouseService {

    private final List<HouseDTO> houses = new ArrayList<>();

    public List<HouseDTO> getAllHouses() {
        return houses;
    }

    public void addHouse(AddHouseRequest addHouseRequest) {
        HouseDTO house = new HouseDTO();
        house.setId(((long) this.houses.size()));
        house.setRooms(addHouseRequest.getRooms());
        house.setPrice(addHouseRequest.getPrice());
        house.setContact(addHouseRequest.getContact());
        house.setDescription(addHouseRequest.getDescription());
        house.setLocation(addHouseRequest.getLocation());
        this.houses.add(house);
    }

}
