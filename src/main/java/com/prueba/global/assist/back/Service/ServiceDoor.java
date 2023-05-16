package com.prueba.global.assist.back.Service;

import com.prueba.global.assist.back.Entity.Door;
import com.prueba.global.assist.back.MyExeptions.MyExeption;
import org.springframework.stereotype.Service;

public interface ServiceDoor {
    public Door saveDoor(Door door);
    public Door findDoorById(String id) throws MyExeption;
}
