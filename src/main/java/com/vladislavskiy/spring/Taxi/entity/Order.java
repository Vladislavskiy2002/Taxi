package com.vladislavskiy.spring.Taxi.entity;

import org.hibernate.query.criteria.internal.expression.function.SqrtFunction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "order_status")
    private boolean order_status;

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "comfort_level")
    private String comfort_level;

    public Order() {
    }

    public long countPriceForTrip()
    {
        long priceTripForOneKmLow = 2;
        long priceTripForOneKmStandart = 3;
        long priceTripForOnekmPrime = 6;
        long distance;
        long tempCount = 0;
        if(comfort_level == "business" || comfort_level == "prime")
            tempCount = priceTripForOnekmPrime;
        else if(comfort_level == "standart" || comfort_level == "Standart")
            tempCount = priceTripForOneKmStandart;
        else if(comfort_level == "low" || comfort_level == "Low")
            tempCount = priceTripForOnekmPrime;

        distance = (long)((Math.pow(address.getXb() - address.getXa(),2) + Math.pow((address.getYb()) - address.getYa(),2)));
        return tempCount * distance;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", order_status=" + order_status +
                ", address=" + address +
                ", comfort_level='" + comfort_level + '\'' +
                '}';
    }
}
