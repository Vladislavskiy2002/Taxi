package com.vladislavskiy.spring.Taxi.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "X_a")
    private long xa;
    @Column(name = "X_b")
    private long xb;
    @Column(name = "Y_a")
    private long ya;
    @Column(name = "Y_b")
    private long yb;
  //Todo: camelcase +

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getXa() {
        return xa;
    }

    public void setXa(long xa) {
        this.xa = xa;
    }

    public long getXb() {
        return xb;
    }

    public void setXb(long xb) {
        this.xb = xb;
    }

    public long getYa() {
        return ya;
    }

    public void setYa(long ya) {
        this.ya = ya;
    }

    public long getYb() {
        return yb;
    }

    public void setYb(long yb) {
        this.yb = yb;
    }
//    public Address(int id, long xa, long xb, long ya, long yb) {
//        this.id = id;
//        Xa = xa;
//        Xb = xb;
//        Ya = ya;
//        Yb = yb;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public long getXa() {
//        return Xa;
//    }
//
//    public void setXa(long xa) {
//        Xa = xa;
//    }
//
//    public long getXb() {
//        return Xb;
//    }
//
//    public void setXb(long xb) {
//        Xb = xb;
//    }
//
//    public long getYa() {
//        return Ya;
//    }
//
//    public void setYa(long ya) {
//        Ya = ya;
//    }
//
//    public long getYb() {
//        return Yb;
//    }
//
//    public void setYb(long yb) {
//        Yb = yb;
//    }
//
//    @Override
//    public String toString() {
//        return "Address{" +
//                "id=" + id +
//                ", Xa=" + Xa +
//                ", Xb=" + Xb +
//                ", Ya=" + Ya +
//                ", Yb=" + Yb +
//                '}';
//    }
}
