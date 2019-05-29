package com.Carapp.ma18CarAppserverspring.Repositories;


import com.Carapp.ma18CarAppserverspring.Booking;
import com.Carapp.ma18CarAppserverspring.Car;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary

public interface CarRepo extends JpaRepository<Car, Long> { }
