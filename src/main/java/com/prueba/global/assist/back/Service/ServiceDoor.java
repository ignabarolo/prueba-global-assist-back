package com.prueba.global.assist.back.Service;

import com.prueba.global.assist.back.Entity.Door;
import org.springframework.stereotype.Service;

public interface ServiceDoor {
    public Door saveDoor(Door door);
    public Door findDoorById(String id);
}
