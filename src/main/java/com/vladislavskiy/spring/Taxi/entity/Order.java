package com.vladislavskiy.spring.Taxi.entity;

import org.hibernate.query.criteria.internal.expression.function.SqrtFunction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "order_status")
    private boolean orderStatus;
    //Todo: camelcase +

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
//TODO: коммент +
    @Column(name = "comfort_level")
    private String comfortLevel;
    //Todo: camelcase +

    public Order() {
    }
//    public boolean isOrderHasCorrectComfortLevel()
//    {
//        long priceTripForOneKmLow = 2;
//        long priceTripForOneKmStandart = 3;
//        long priceTripForOnekmPrime = 6;
//        long distance;
//        long tempCount = 0;
//        if(comfort_level.equals("business") || comfort_level.equals("prime") || comfort_level.equals("PRIME"))
//            tempCount = priceTripForOnekmPrime;
//        else if(comfort_level.equals("standart") || comfort_level.equals("Standart"))
//            tempCount = priceTripForOneKmStandart;
//        else if(comfort_level.equals("low") || comfort_level.equals("Low"))
//            tempCount = priceTripForOnekmPrime;
//
//        distance = (long)((Math.pow(address.getXb() - address.getXa(),2) + Math.pow((address.getYb()) - address.getYa(),2)));
//        return tempCount * distance;
//    }

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
        return orderStatus;
    }

    public void setOrder_status(boolean order_status) {
        this.orderStatus = order_status;
    }

    public boolean isStatus() {
        return orderStatus;
    }

    public void setStatus(boolean status) {
        this.orderStatus = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getComfort_level() {
        return comfortLevel;
    }

    public void setComfort_level(String comfort_level) {
        this.comfortLevel = comfort_level;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", orderStatus=" + orderStatus +
                ", address=" + address +
                ", comfortLevel='" + comfortLevel + '\'' +
                '}';
    }
}
