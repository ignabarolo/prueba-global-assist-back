package com.prueba.global.assist.back.ServiceImplementation;

import com.prueba.global.assist.back.DTO.EntryDTO;
import com.prueba.global.assist.back.Entity.Door;
import com.prueba.global.assist.back.Entity.Entry;
import com.prueba.global.assist.back.Entity.Guest;
import com.prueba.global.assist.back.MyExeptions.MyExeption;
import com.prueba.global.assist.back.Repository.EntryRepository;
import com.prueba.global.assist.back.Service.ServiceDoor;
import com.prueba.global.assist.back.Service.ServiceEntry;
import com.prueba.global.assist.back.Service.ServiceGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ServiceEntryImpl implements ServiceEntry {
    @Autowired
    private EntryRepository entryRepository;
    @Autowired
    private ServiceGuest serviceGuest;
    @Autowired
    private ServiceDoor serviceDoor;

    @Override
    public Entry saveEntry(EntryDTO entryDTO) {
        Entry entry = mapearEntidad(entryDTO);
        entryRepository.save(entry);
        return entry;
    }

    @Override
    public Entry findEntryById(String id) throws MyExeption {
        Optional<Entry> rtaEntry = entryRepository.findById(id);
        if (rtaEntry.isPresent()) {
            Entry entry = rtaEntry.get();
            return entry;
        } else {
            throw new MyExeption("Id Entry Unknown");
        }
    }

    @Override//Lista por rango y ID
    public List<Entry> findEntryByDateRangeAndDoorId(String fromDate, String toDate, String doorId) throws MyExeption {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDateTime = null;
        Date toDateTime = null;
        try {
            fromDateTime = formatter.parse(fromDate);
            toDateTime = formatter.parse(toDate);
        } catch (ParseException e) {
            throw new MyExeption("Error: Unexpected parsing Dates");
        }
        return entryRepository.findByBetweenAndDoorId(fromDateTime,toDateTime,doorId);
    }

    @Override
    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    @Override
    public EntryDTO mapearDTO(Entry entry) {
        EntryDTO entryDTO = new EntryDTO();
        entryDTO.setId(entry.getId());
        entryDTO.setCreated(entry.getCreated());
        return entryDTO;
    }

    @Override
    public Entry mapearEntidad(EntryDTO entryDTO) {
        Guest guest = serviceGuest.findGuestById(entryDTO.getGuestId());
        Door door = serviceDoor.findDoorById(entryDTO.getDoorId());

        Entry entry = new Entry();
        entry.setId(entryDTO.getId());
        entry.setGuest(guest);
        entry.setDoor(door);
        entry.setCreated(entryDTO.getCreated());
        return entry;
    }

    @Override
    public void deleteEntry(String id) throws MyExeption{
        Entry entry = findEntryById(id);
        entryRepository.delete(entry);
    }
}
