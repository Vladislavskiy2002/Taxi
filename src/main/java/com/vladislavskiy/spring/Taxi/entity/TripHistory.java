package com.vladislavskiy.spring.Taxi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity()
@Table(name = "trip_information2")
public class TripHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "trip_info")
    private String infoAboutTrip;


    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public TripHistory() {
    }
    public TripHistory(String infoAboutTrip, User user) {
        this.infoAboutTrip = infoAboutTrip;
        this.user = user;
    }
    //TODO: два однакові методи для сет юзер +

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


    @Override
    public String toString() {
        return "TripHistory{" +
                "id=" + id +
                ", infoAboutTrip='" + infoAboutTrip + '\'' +
                ", user=" + user.getId() +
                '}';
    }
}
