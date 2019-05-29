package com.Carapp.ma18CarAppserverspring.Repositories;


import com.Carapp.ma18CarAppserverspring.Booking;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary

public interface BookingRepo extends JpaRepository<Booking, Long> { }
