package com.vladislavskiy.spring.Taxi.entity;

import javax.persistence.*;
import java.util.*;

@Entity(name = "users2")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TripHistory> tripHistory;

    public void addTripForUser(TripHistory tripHistory)
    {
        this.tripHistory.add(tripHistory);
    }

    public User() {
        tripHistory = new ArrayList<>();
    }

    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public User(String name, String surname, TripHistory tripHistory) {
        this.name = name;
        this.surname = surname;
        this.addTripForUser(tripHistory);
    }

    public User(TripHistory tripHistory) {
        this.tripHistory = new ArrayList<>();
        this.addTripForUser(tripHistory);;
    }
}
