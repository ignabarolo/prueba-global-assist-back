package com.prueba.global.assist.back.Service;

import com.prueba.global.assist.back.Entity.Guest;
import org.springframework.stereotype.Service;

public interface ServiceGuest {

    public Guest saveGuest(Guest gest);

    public Guest findGuestById(String id);

}
