package com.prueba.global.assist.back.Controller;

import com.prueba.global.assist.back.DTO.EntryDTO;
import com.prueba.global.assist.back.Entity.Door;
import com.prueba.global.assist.back.Entity.Entry;
import com.prueba.global.assist.back.Entity.Guest;
import com.prueba.global.assist.back.MyExeptions.MyExeption;
import com.prueba.global.assist.back.Service.ServiceEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/entries")
public class EntryController {

    @Autowired
    private ServiceEntry serviceEntry;

//    @PostMapping("/guardar")
//    public ResponseEntity<Entry> insertarGuest(@RequestBody EntryDTO entryDTO, @RequestParam("GuestId") String guestId, @RequestParam("DoorId") String doorId){
//        return new ResponseEntity<>(serviceEntry.saveEntry(entryDTO,guestId,doorId), HttpStatus.CREATED);
//    }

    @PostMapping("/guardar")
    public ResponseEntity<Entry> insertarGuest(@RequestBody EntryDTO entryDTO){
        return new ResponseEntity<>(serviceEntry.saveEntry(entryDTO), HttpStatus.CREATED);
    }

//    @GetMapping("/busquedaId")
//    public ResponseEntity<?> findById(@RequestParam("EntryId") String entryId){
//        try {
//            return new ResponseEntity<>(serviceEntry.findEntryById(entryId), HttpStatus.OK);
//        } catch (MyExeption e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
//        }
//
//    }

//    @GetMapping("/{doorId}/{fromDate}/{toDate}")
//    public ResponseEntity<?> findByIdInARange(@PathVariable("doorId") String doorId, @PathVariable() String fromDate, @PathVariable() String toDate){
//        try {
//            return new ResponseEntity<>(serviceEntry.findEntryByDateRangeBetweenAndDoorId(fromDate, toDate, doorId), HttpStatus.OK);
//        } catch (MyExeption e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
//        }
//    }

//    @GetMapping("/{doorId}/{fromDate}/{toDate}")
//    public ResponseEntity<?> findByIdInARange(@PathVariable("doorId") String doorId, @PathVariable("fromDate") String fromDate, @PathVariable() String toDate){
//        try {
//            return new ResponseEntity<>(serviceEntry.findEntryByDateRangeBetweenAndDoorId(fromDate, toDate, doorId), HttpStatus.OK);
//        } catch (MyExeption e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
//        }
//    }

    @GetMapping("")
    public ResponseEntity<?> findByIdInARange(@RequestParam("DoorId") String doorId, @RequestParam("FromDate") String fromDate, @RequestParam("ToDate") String toDate){
        try {
            return new ResponseEntity<>(serviceEntry.findEntryByDateRangeAndDoorId(fromDate, toDate, doorId), HttpStatus.OK);
        } catch (MyExeption e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(serviceEntry.findAll(), HttpStatus.OK);
    }

    //Controlador de Prueba
//    @GetMapping("/{doorId}")
//    public String findByIdInARange(@PathVariable String doorId){
//        return doorId ;
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteEntry(@PathVariable("id") String entryId){
//        try {
//            serviceEntry.deleteEntry(entryId);
//            String respuesta = new String("Entry Succesfully Deleted");
//            return new ResponseEntity<>(respuesta, HttpStatus.OK);
//        } catch (MyExeption e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
//        }
//    }

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
