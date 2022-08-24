package com.vladislavskiy.spring.Taxi.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "A")
    private long A;
    @Column(name = "B")
    private long B;

    public Address() {
    }

    public Address(long a, long b) {
        A = a;
        B = b;
    }

    public long getA() {
        return A;
    }

    public void setA(long a) {
        A = a;
    }

    public long getB() {
        return B;
    }

    public void setB(long b) {
        B = b;
    }
}
