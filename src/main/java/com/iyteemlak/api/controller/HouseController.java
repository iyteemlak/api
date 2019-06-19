package com.iyteemlak.api.controller;

import com.iyteemlak.api.model.dto.HouseDTO;
import com.iyteemlak.api.model.request.AddHouseRequest;
import com.iyteemlak.api.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("house")
public class HouseController {

    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping(produces = "application/json")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<HouseDTO> getAllHouses() {
        return houseService.getAllHouses();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://localhost:3000")
    public void addHouse(@RequestBody AddHouseRequest addHouseRequest) {
        houseService.addHouse(addHouseRequest);
    }

}
