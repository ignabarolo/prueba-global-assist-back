package com.prueba.global.assist.back.Controller;

import com.prueba.global.assist.back.Entity.Guest;
import com.prueba.global.assist.back.MyExeptions.MyExeption;
import com.prueba.global.assist.back.Service.ServiceGuest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guest")
@Tag(name = "Guest")
public class GestController {

    @Autowired
    private ServiceGuest gestService;

    @Operation(
            description = "ENDPOINT: http://localhost:8080/api/guest/guardar",
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
    public ResponseEntity<Guest> insertarGuest(@RequestBody Guest guest){
        return ResponseEntity.ok(gestService.saveGuest(guest));
    }

    @Operation(
            description = "ENDPOINT: http://localhost:8080/api/GuestId={id}",
            summary = "This Endpoint is for Search a Guest by ID",
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
    public ResponseEntity<?> findById(@RequestParam("GuestId") String guestId){
        try {
            return new ResponseEntity<>(gestService.findGuestById(guestId), HttpStatus.OK);
        } catch (MyExeption e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
