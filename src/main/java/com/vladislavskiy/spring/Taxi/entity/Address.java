package com.vladislavskiy.spring.Taxi.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "X_a")
    private long Xa;
    @Column(name = "X_b")
    private long Xb;
    @Column(name = "Y_a")
    private long Ya;
    @Column(name = "Y_b")
    private long Yb;

    public Address() {
    }

    public Address(int id, long xa, long xb, long ya, long yb) {
        this.id = id;
        Xa = xa;
        Xb = xb;
        Ya = ya;
        Yb = yb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getXa() {
        return Xa;
    }

    public void setXa(long xa) {
        Xa = xa;
    }

    public long getXb() {
        return Xb;
    }

    public void setXb(long xb) {
        Xb = xb;
    }

    public long getYa() {
        return Ya;
    }

    public void setYa(long ya) {
        Ya = ya;
    }

    public long getYb() {
        return Yb;
    }

    public void setYb(long yb) {
        Yb = yb;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", Xa=" + Xa +
                ", Xb=" + Xb +
                ", Ya=" + Ya +
                ", Yb=" + Yb +
                '}';
    }
}
