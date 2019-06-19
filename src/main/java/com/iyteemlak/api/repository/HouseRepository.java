package com.iyteemlak.api.repository;

import com.iyteemlak.api.entity.House;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HouseRepository extends CrudRepository<House, Long> {

    @Query(value = "SELECT * FROM house WHERE is_active = true", nativeQuery = true)
    List<House> getActiveHouses();

}