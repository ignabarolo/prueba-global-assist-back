package com.prueba.global.assist.back.Repository;

import com.prueba.global.assist.back.Entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, String> {
}
