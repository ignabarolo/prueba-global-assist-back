package com.prueba.global.assist.back.Controller;

import com.prueba.global.assist.back.Entity.Door;
import com.prueba.global.assist.back.MyExeptions.MyExeption;
import com.prueba.global.assist.back.Service.ServiceDoor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/door")
@Tag(name = "Door")
public class DoorController {

    @Autowired
    private ServiceDoor serviceDoor;

    @Operation(
            description = "ENDPOINT: http://localhost:8080/api/door/guardar",
            summary = "This Endpoint is for Save a Door",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "No result found",
                            responseCode = "401"
                    )
            }
    )
    @PostMapping("/guardar")
    public ResponseEntity<Door> insertarGuest(@RequestBody Door door){
        return new ResponseEntity<>(serviceDoor.saveDoor(door), HttpStatus.CREATED);
    }

    @Operation(
            description = "ENDPOINT: http://localhost:8080/api/DoorId={id}",
            summary = "This Endpoint is for Search a Door by ID",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "No result found",
                            responseCode = "401"
                    )
            }
    )
    @GetMapping("")
    public ResponseEntity<?> findById(@RequestParam("DoorId") String doorId){
        try {
            return new ResponseEntity<>(serviceDoor.findDoorById(doorId), HttpStatus.OK);
        } catch (MyExeption e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

}
