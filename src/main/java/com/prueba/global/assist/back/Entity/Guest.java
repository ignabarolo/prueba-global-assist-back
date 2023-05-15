package com.prueba.global.assist.back.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String firstname;
    private String lastname;

//    @ManyToMany(mappedBy = "guests")
//    private Set<Door> doors = new HashSet<>();
}
