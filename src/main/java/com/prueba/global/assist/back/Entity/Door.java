package com.prueba.global.assist.back.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Door {

//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
//    private String id;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    private String description;


//    @ManyToMany
//    @JoinTable(name= "entry", joinColumns = @JoinColumn(name="door_id"), inverseJoinColumns = @JoinColumn(name="guest_id"))
//    private Set<Guest> guests = new HashSet<>();
}
