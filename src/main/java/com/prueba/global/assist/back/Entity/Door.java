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
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String description;
}
