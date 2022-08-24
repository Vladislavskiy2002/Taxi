package com.vladislavskiy.spring.Taxi.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "status")
    private boolean order_status;

    @OneToOne
    @JoinColumn(name = "address")
    private Address address;

    @Column(name = "comfort_level")
    private String comfort_level;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isOrder_status() {
        return order_status;
    }

    public void setOrder_status(boolean order_status) {
        this.order_status = order_status;
    }

    public boolean isStatus() {
        return order_status;
    }

    public void setStatus(boolean status) {
        this.order_status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getComfort_level() {
        return comfort_level;
    }

    public void setComfort_level(String comfort_level) {
        this.comfort_level = comfort_level;
    }
}
