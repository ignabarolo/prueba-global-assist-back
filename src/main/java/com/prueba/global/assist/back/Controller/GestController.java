package com.prueba.global.assist.back.Controller;

import com.prueba.global.assist.back.Entity.Door;
import com.prueba.global.assist.back.Entity.Guest;
import com.prueba.global.assist.back.Service.ServiceGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guest")
public class GestController {

    @Autowired
    private ServiceGuest gestService;
    @PostMapping("/guardar")
    public ResponseEntity<Guest> insertarGuest(@RequestBody Guest guest){
        return ResponseEntity.ok(gestService.saveGuest(guest));
    }

    @GetMapping("")
    public ResponseEntity<Guest> findById(@RequestParam("GuestId") String guestId){
        return new ResponseEntity<>(gestService.findGuestById(guestId), HttpStatus.OK);
    }
}
