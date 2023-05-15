package com.prueba.global.assist.back.Controller;

import com.prueba.global.assist.back.Entity.Door;
import com.prueba.global.assist.back.Entity.Guest;
import com.prueba.global.assist.back.Service.ServiceDoor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/door")
public class DoorController {

    @Autowired
    private ServiceDoor serviceDoor;

    @PostMapping("/guardar")
    public ResponseEntity<Door> insertarGuest(@RequestBody Door door){
        return new ResponseEntity<>(serviceDoor.saveDoor(door), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Door> findById(@RequestParam("DoorId") String doorId){
        return new ResponseEntity<>(serviceDoor.findDoorById(doorId), HttpStatus.OK);
    }

}
