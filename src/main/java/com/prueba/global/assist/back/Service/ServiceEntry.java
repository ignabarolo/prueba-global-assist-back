package com.prueba.global.assist.back.Service;

import com.prueba.global.assist.back.DTO.EntryDTO;
import com.prueba.global.assist.back.Entity.Entry;
import com.prueba.global.assist.back.MyExeptions.MyExeption;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface ServiceEntry {

//    public Entry saveEntry(EntryDTO entryDTO, String idGuest, String idDoor);
    public Entry saveEntry(EntryDTO entryDTO);
    public Entry findEntryById(String id) throws MyExeption;
    public List<Entry> findEntryByDateRangeAndDoorId(String fromDate, String toDate, String doorId) throws MyExeption;
    public List<Entry> findAll();
    public EntryDTO mapearDTO(Entry entry);
    public Entry mapearEntidad(EntryDTO entryDTO);
    public void deleteEntry(String id) throws MyExeption;
}
