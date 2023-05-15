package com.prueba.global.assist.back.Repository;

import com.prueba.global.assist.back.Entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, String> {
//    List<Entry> findByStartDateBetween(Date fromDate, Date toDate);

    @Query("SELECT e FROM Entry e WHERE e.created BETWEEN :fromDate AND :toDate AND e.door.id = :doorId")
    List<Entry> findByBetweenAndDoorId(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("doorId") String doorId);
}

