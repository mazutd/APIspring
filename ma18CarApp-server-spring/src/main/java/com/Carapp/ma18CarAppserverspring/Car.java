package com.Carapp.ma18CarAppserverspring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONArray;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String name;
    private final String imageUrl;
    private final String year;
    private boolean hyrd;
    private final String model;
    private final String price;



    private final String discription;


    public Car() {
        this.hyrd = false;
        this.price = "";
        this.discription = "";
        this.imageUrl = "";
        this.year = "";
        this.model = "";
        this.name = "";

    }




    public Car(String name, String imageUrl, String year, boolean hyrd, String model, String price, String discription) {

        this.name = name;
        this.imageUrl = imageUrl;
        this.year = year;
        this.hyrd = hyrd;
        this.model = model;
        this.price = price;
        this.discription = discription;

    }
    public void setId(long id) { this.id = id; }
    public String getDiscription() { return discription; }
    public String getModel() { return model; }
    public long getId() { return id; }
    public String getName() { return name; }
    public String getYear() { return year; }
    public String getImageUrl() { return imageUrl; }
    public String getPrice() { return price; }
    public boolean isHyrd() { return hyrd; }
    public void setHyrd(boolean hyrd) { this.hyrd=hyrd; }



}
