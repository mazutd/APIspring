package com.Carapp.ma18CarAppserverspring.Controllers;

import com.Carapp.ma18CarAppserverspring.Booking;
import com.Carapp.ma18CarAppserverspring.Car;
import com.Carapp.ma18CarAppserverspring.Repositories.BookingRepo;
import com.Carapp.ma18CarAppserverspring.Repositories.CarRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.io.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {

    private final CarRepo carRepository;
    private final BookingRepo bookingRepository;
    public CarController(CarRepo carRepository, BookingRepo bookingRepository) {
        this.carRepository = carRepository;
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/cars")
    public List<Car> getUsers() {

        return (List<Car>) carRepository.findAll();

    }

    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable Long id) throws JsonProcessingException {
        System.out.println(id+"sdss");
        carRepository.deleteById(id);
        carRepository.findAll();
        String json = new ObjectMapper().writeValueAsString(carRepository.findAll());

        JsonFileMocka(json);
    }

    @PostMapping("/cars")
    void addUser(@RequestBody Car user) throws JsonProcessingException {
            carRepository.save(user);
            String json = new ObjectMapper().writeValueAsString(carRepository.findAll());
            System.out.println(json);
            JsonFileMocka(json);
    }



    @GetMapping("/bookings")
    public List<Booking> getthisBooking() {
        return  bookingRepository.findAll();
    }

    @PostMapping("/cars/{id}/booking")
    Optional<Booking> addBooking(@RequestBody Booking booking, @PathVariable Long id) {
        System.out.println(id);
        String json = null;
        booking.setBilId(id.toString());
        bookingRepository.save(booking);
        try {
            json = new ObjectMapper().writeValueAsString(bookingRepository.findAll());
            System.out.println(new ObjectMapper().writeValueAsString(booking)+"BOOKIBNG");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //System.out.println(json);
        JsonFileBookingMocka(json);
        return Optional.of(booking);
    }
    @GetMapping("/bookings/{id}")
    Optional<Booking> getBooking(@PathVariable Long id) {
        System.out.println(carRepository.findById(id)+"boking");

        return bookingRepository.findById(id);
    }
    @GetMapping("/cars/{id}")
    Optional<Car> editUser(@PathVariable Long id) {
        System.out.println(carRepository.findById(id)+"get");

        return carRepository.findById(id);
    }

    @PutMapping("/cars/{id}")
    Optional<Car> addBookingCar(@RequestBody Car json, @PathVariable Long id) throws JsonProcessingException, JSONException {
         json.setId(id);
         json.setHyrd(true);
         carRepository.save(json);
         String carjson = new ObjectMapper().writeValueAsString(carRepository.findAll());
         JsonFileMocka(carjson);

        return carRepository.findById(id);
    }


    private void JsonFileMocka(String json) {
        File JSONOutputFile = new File("src/main/resources/JSON.json");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(JSONOutputFile, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            JSONArray jsonObj = new JSONArray(json);

            writer.println(jsonObj);
            writer.close();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    private void JsonFileBookingMocka(String json) {
        File JSONOutputFile = new File("src/main/resources/bookings.json");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(JSONOutputFile, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            JSONArray jsonObj = new JSONArray(json);

            writer.println(jsonObj);
            writer.close();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    }
