package com.boavontade.parking.service;

import com.boavontade.parking.model.Parking;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;

@Service
public class ParkingService {

        private  static Map<String, Parking> parkingMap = new HashMap();

    static  {
        var id = getUUID();
        Parking parking = new Parking(id, "SSP-1234", "SP", "GOL", "BLUE");
        parkingMap.put(id, parking);
    }
    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }
private  static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
}

}
