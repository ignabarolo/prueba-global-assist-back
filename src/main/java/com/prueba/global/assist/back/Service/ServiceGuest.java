package com.prueba.global.assist.back.Service;

import com.prueba.global.assist.back.Entity.Guest;
import com.prueba.global.assist.back.MyExeptions.MyExeption;
import org.springframework.stereotype.Service;

public interface ServiceGuest {
    public Guest saveGuest(Guest gest);
    public Guest findGuestById(String id) throws MyExeption;

}
