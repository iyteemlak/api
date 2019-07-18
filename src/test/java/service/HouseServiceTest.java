package service;

import com.iyteemlak.api.entity.House;
import com.iyteemlak.api.model.dto.HouseDTO;
import com.iyteemlak.api.model.dto.LatLngDTO;
import com.iyteemlak.api.model.request.AddHouseRequest;
import com.iyteemlak.api.repository.HouseRepository;
import com.iyteemlak.api.service.HouseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HouseServiceTest {

    @InjectMocks
    private HouseService houseService;

    @Mock
    private HouseRepository houseRepository;

    @Test
    public void it_should_get_all_houses() {
        // Given
        LocalDateTime now = LocalDateTime.now();

        House house = new House();
        house.setId(1L);
        house.setRooms("1+1");
        house.setPrice(123);
        house.setContact("05555555555");
        house.setDescription("desc");
        house.setLat(0.0);
        house.setLng(0.0);
        house.setCreatedAt(now);
        house.setUpdatedAt(now);

        when(houseRepository.getActiveHouses()).thenReturn(Arrays.asList(house));

        // When
        List<HouseDTO> result = houseService.getAllHouses();

        // Then
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getId(), 0.1);
        assertNotNull(result.get(0).getLocation());
        assertEquals(0.0, result.get(0).getLocation().getLat(), 0.001);
        assertEquals(0.0, result.get(0).getLocation().getLng(), 0.001);
    }

    @Test
    public void it_should_add_house_and_is_active_should_be_false() {
        // Given
        LatLngDTO latLngDTO = new LatLngDTO();
        latLngDTO.setLat(0.0);
        latLngDTO.setLng(0.0);

        AddHouseRequest addHouseRequest = new AddHouseRequest();
        addHouseRequest.setRooms("1+1");
        addHouseRequest.setPrice(123);
        addHouseRequest.setContact("05555555555");
        addHouseRequest.setDescription("desc");
        addHouseRequest.setLocation(latLngDTO);

        // When
        House house = houseService.addHouse(addHouseRequest);

        // Then
        assertEquals("1+1", house.getRooms());
        assertEquals(123, house.getPrice(), 0.1);
        assertEquals("05555555555", house.getContact());
        assertEquals("desc", house.getDescription());
        assertEquals(0.0, house.getLat(), 0.001);
        assertEquals(0.0, house.getLng(), 0.001);
        assertEquals(false, house.getActive());
        verify(houseRepository).save(house);
    }

    @Test
    public void it_should_add_house_when_location_is_null() {
        // Given
        AddHouseRequest addHouseRequest = new AddHouseRequest();
        addHouseRequest.setRooms("1+1");
        addHouseRequest.setPrice(123);
        addHouseRequest.setContact("05555555555");
        addHouseRequest.setDescription("desc");
        addHouseRequest.setLocation(null);

        // When
        House house = houseService.addHouse(addHouseRequest);

        // Then
        assertNull(house.getLat());
        assertNull(house.getLng());
        verify(houseRepository).save(house);
    }

}
