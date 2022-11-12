package com.boavontade.parking.controlle;

import com.boavontade.parking.controlle.dto.ParkingDTO;
import com.boavontade.parking.controlle.mapper.ParkingMapper;
import com.boavontade.parking.model.Parking;
import java.util.List;
import com.boavontade.parking.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/parking")
public class ParkingController {
       private final ParkingService parkingService;
       private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }
    @GetMapping
    public List<ParkingDTO> findAll() {
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return result;
    }

}
