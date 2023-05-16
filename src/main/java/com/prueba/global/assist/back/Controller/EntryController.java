package com.prueba.global.assist.back.Controller;

import com.prueba.global.assist.back.DTO.EntryDTO;
import com.prueba.global.assist.back.Entity.Door;
import com.prueba.global.assist.back.Entity.Entry;
import com.prueba.global.assist.back.Entity.Guest;
import com.prueba.global.assist.back.MyExeptions.MyExeption;
import com.prueba.global.assist.back.Service.ServiceEntry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entries")
@Tag(name = "Entry")
public class EntryController {

    @Autowired
    private ServiceEntry serviceEntry;

    @Operation(
            description = "The format of the Dates must be: YYYY/MM/DD",
            summary = "This Endpoint is for Save an Entry",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "No results found",
                            responseCode = "401"
                    )
            }
    )
    @PostMapping("/guardar")
    public ResponseEntity<Entry> insertarGuest(@RequestBody EntryDTO entryDTO){
        return new ResponseEntity<>(serviceEntry.saveEntry(entryDTO), HttpStatus.CREATED);
    }

    @Operation(
            description = "ENDPOINT: http://localhost:8080/api/entries/sarchid/{id}",
            summary = "This Endpoint is for Search an Entry by ID",
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
    @GetMapping("/sarchid/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String entryId){
        try {
            return new ResponseEntity<>(serviceEntry.findEntryById(entryId), HttpStatus.OK);
        } catch (MyExeption e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }

    }

//    @GetMapping("/{doorId}/{fromDate}/{toDate}")
//    public ResponseEntity<?> findByIdInARange(@PathVariable("doorId") String doorId, @PathVariable("fromDate") String fromDate, @PathVariable() String toDate){
//        try {
//            System.out.println(doorId + " " + fromDate + " " + toDate);
//            return new ResponseEntity<>(serviceEntry.findEntryByDateRangeAndDoorId(fromDate, toDate, doorId), HttpStatus.OK);
//        } catch (MyExeption e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
//        }
//    }

    @Operation(
            description = "The format of the Dates must be: YYYY/MM/DD",
            summary = "This Endpoint is for Search Entries by a Date range and a DoorID",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "No results found",
                            responseCode = "401"
                    )
            }
    )
    @GetMapping("")
    public ResponseEntity<?> findByIdInARange(@RequestParam("DoorId") String doorId, @RequestParam("FromDate") String fromDate, @RequestParam("ToDate") String toDate){
        try {
            System.out.println(doorId + " " + fromDate + " " + toDate);
            List<Entry> lista = serviceEntry.findEntryByDateRangeAndDoorId(fromDate, toDate, doorId);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (MyExeption e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @Operation(
            description = "ENDPOINT: http://localhost:8080/api/entries/",
            summary = "This Endpoint is for List all Entries",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "No results found",
                            responseCode = "401"
                    )
            }
    )
    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        List<Entry> response = serviceEntry.findAll();
        if (response.size() != 0){
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No results found", HttpStatus.UNAUTHORIZED);
        }


    }

    //Controlador de Prueba
//    @GetMapping("/{doorId}")
//    public String findByIdInARange(@PathVariable String doorId){
//        return doorId ;
//    }

    @Operation(
            description = "ENDPOINT: http://localhost:8080/api/entries/{id}",
            summary = "This Endpoint is for DELETE an Entry",
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
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteEntry(@PathVariable("id") String entryId){
        try {
            serviceEntry.deleteEntry(entryId);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Entrada eliminada exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (MyExeption e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }

}
