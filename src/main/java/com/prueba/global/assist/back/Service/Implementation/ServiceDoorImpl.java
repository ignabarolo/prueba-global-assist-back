package com.prueba.global.assist.back.Service.Implementation;

import com.prueba.global.assist.back.Entity.Door;
import com.prueba.global.assist.back.Entity.Guest;
import com.prueba.global.assist.back.Repository.DoorRepository;
import com.prueba.global.assist.back.Service.ServiceDoor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceDoorImpl implements ServiceDoor {

    @Autowired
    private DoorRepository doorRepository;

    @Override
    public Door saveDoor(Door door) {
        doorRepository.save(door);
        return door;
    }

    @Override
    public Door findDoorById(String id) {
        Optional<Door> rtaDoor = doorRepository.findById(id);
        if (rtaDoor.isPresent()) {
            Door door = rtaDoor.get();
            return door;
        } else {
            throw new Error("Door Unknown");
        }
    }
}
