package com.iyteemlak.api.service;

import com.iyteemlak.api.model.dto.HouseDTO;
import com.iyteemlak.api.model.request.AddHouseRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HouseService {

    private final List<HouseDTO> houses;

    public HouseService() {
        HouseDTO house = new HouseDTO();
        house.setId(1L);
        house.setRooms("2+1");
        house.setPrice(500);
        house.setContact("12123123123123");
        house.setDescription("asfasdfasdf");
        house.setLocation(null);

        this.houses = new ArrayList<>();
        this.houses.add(house);
    }

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
//        house.setLocation(addHouseRequest.getLocation());
        this.houses.add(house);
    }

}
