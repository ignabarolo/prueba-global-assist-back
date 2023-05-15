package com.prueba.global.assist.back.DTO;

import com.prueba.global.assist.back.Entity.Door;
import com.prueba.global.assist.back.Entity.Guest;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Data
public class EntryDTO {
    private String id;
    private String guestId;
    private String doorId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
}
