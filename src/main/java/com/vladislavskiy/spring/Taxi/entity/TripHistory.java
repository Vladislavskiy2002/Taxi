package com.vladislavskiy.spring.Taxi.entity;

import javax.persistence.*;

@Entity(name = "trip_information2")
public class TripHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "trip_info")
    private String infoAboutTrip;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public TripHistory() {
    }
    public void addUserToTripHistory(User user)
    {
        this.setUser(user);
    }
    public TripHistory(String infoAboutTrip, User user) {
        this.infoAboutTrip = infoAboutTrip;
        this.user = user;
    }

    public TripHistory(String infoAboutTrip) {
        this.infoAboutTrip = infoAboutTrip;
    }

    public int getId(){
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfoAboutTrip() {
        return infoAboutTrip;
    }

    public void setInfoAboutTrip(String infoAboutTrip) {
        this.infoAboutTrip = infoAboutTrip;
    }
}
