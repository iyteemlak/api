package contoller;

import com.iyteemlak.api.controller.HouseController;
import com.iyteemlak.api.model.dto.HouseDTO;
import com.iyteemlak.api.model.dto.LatLngDTO;
import com.iyteemlak.api.model.request.AddHouseRequest;
import com.iyteemlak.api.service.HouseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HouseControllerTest {

    @InjectMocks
    private HouseController houseController;

    @Mock
    private HouseService houseService;

    @Test
    public void it_should_return_all_houses() {
        // Given
        LocalDateTime now = LocalDateTime.now();

        LatLngDTO latLngDTO = new LatLngDTO();
        latLngDTO.setLat(0.0);
        latLngDTO.setLng(0.0);

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setId(1L);
        houseDTO.setRooms("1+1");
        houseDTO.setPrice(123);
        houseDTO.setContact("05555555555");
        houseDTO.setDescription("desc");
        houseDTO.setLocation(latLngDTO);
        houseDTO.setCreatedAt(now);
        houseDTO.setUpdatedAt(now);

        when(houseService.getAllHouses()).thenReturn(Arrays.asList(houseDTO));

        // When
        List<HouseDTO> result = houseController.getAllHouses();

        // Then
        assertEquals(1, result.size());
    }

    @Test
    public void it_should_add_house() {
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
        houseController.addHouse(addHouseRequest);

        // Then
        verify(houseService).addHouse(addHouseRequest);
    }

}
