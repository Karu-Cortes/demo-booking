package com.example.demobooking.domain.repository;


import com.example.demobooking.domain.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingSqlRepository extends JpaRepository<Booking, Long> {
    /* métodos de consulta*/


}
