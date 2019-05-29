package com.Carapp.ma18CarAppserverspring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;



    private String bilId;

    private String email;
    private String fron;
    private String till;
    private String price;

    public Booking(){
    }


    public Booking(String name, String email,String fron, String till, String price, String bilId) {
        this.bilId = bilId;
        this.email = email;
        this.name = name;
        this.till = till;
        this.fron = fron;
        this.price = price;

    }

    public String getName() {
        return name;
    }
    public long getId() { return id; }
    public void setId(long id) { this.id = id;}
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getFron() { return fron; }
    public void setFron(String fron) { this.fron = fron; }
    public String getTill() { return till; }
    public void setTill(String till) { this.till = till; }
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
    public String getBilId() { return bilId; }
    public void setBilId(String bilId) { this.bilId = bilId; }
}
