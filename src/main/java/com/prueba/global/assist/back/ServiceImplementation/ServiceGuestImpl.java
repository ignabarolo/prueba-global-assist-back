package com.prueba.global.assist.back.ServiceImplementation;

import com.prueba.global.assist.back.Entity.Guest;
import com.prueba.global.assist.back.MyExeptions.MyExeption;
import com.prueba.global.assist.back.Repository.GuestRepository;
import com.prueba.global.assist.back.Service.ServiceGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ServiceGuestImpl implements ServiceGuest {
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public Guest saveGuest(Guest gest) {
        guestRepository.save(gest);
        return gest;
    }
    @Override
    public Guest findGuestById(String id) throws MyExeption{
        Optional<Guest> rtaGuest = guestRepository.findById(id);
        if (rtaGuest.isPresent()) {
            Guest guest = rtaGuest.get();
            return guest;
        } else {
            throw new MyExeption("Id Guest Unknown");
        }
    }
}
