package com.boavontade.parking.service;

import com.boavontade.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap();

    static {
        var id = getUUID();
        var id1 = getUUID();
        Parking parking = new Parking(id, "SSP-1234", "SP", "GOL", "BLUE");
        Parking parking1 = new Parking(id1, "SPR-1234", "PR", "GM", "Pink");
        parkingMap.put(id, parking);
        parkingMap.put(id1, parking1);
    }

    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
    return parkingMap.get(id);
    }
    public Parking create(Parking parkingCreate) {
    String uuid = getUUID();
    parkingCreate.setId(uuid);
    parkingCreate.setEntryDate(LocalDateTime.now());
    parkingMap.put(uuid, parkingCreate);
    return  parkingCreate;
    }
}
