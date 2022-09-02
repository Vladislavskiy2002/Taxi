package com.vladislavskiy.spring.Taxi.dao;

import com.vladislavskiy.spring.Taxi.entity.Order;
import com.vladislavskiy.spring.Taxi.entity.TripHistory;
import com.vladislavskiy.spring.Taxi.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUser(int id);
    void addOrUpdateUser(User user);
    List<User> getAllTripHistoryFromCurrentUser(int id);
    public boolean addOrUpdateTrip(TripHistory tripHistory);
    public boolean addOrUpdateOrder(Order order);
    public Order getOrderByUserId(int id);
    public boolean isCurrentUsersOrderNull(Order order);
    public void completeUsersOrder(Order order);
    public void deleteOrder(Order order);
    public Order getOrderById(int id);
}


