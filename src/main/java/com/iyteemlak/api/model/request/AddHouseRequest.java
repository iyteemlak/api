package com.iyteemlak.api.model.request;

import com.iyteemlak.api.model.dto.LatLngDTO;

public class AddHouseRequest {

    private String rooms;
    private Integer price;
    private String contact;
    private String description;
    private LatLngDTO location;

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LatLngDTO getLocation() {
        return location;
    }

    public void setLocation(LatLngDTO location) {
        this.location = location;
    }
}
