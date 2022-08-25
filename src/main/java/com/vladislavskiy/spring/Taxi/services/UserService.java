package com.vladislavskiy.spring.Taxi.services;

import com.vladislavskiy.spring.Taxi.entity.Order;
import com.vladislavskiy.spring.Taxi.entity.TripHistory;
import com.vladislavskiy.spring.Taxi.entity.User;
import org.hibernate.Session;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(int id);
    void addOrUpdateUser(User user);
    public List<User> getAllTripHistoryFromCurrentUser(int id);
    public void addOrUpdateTrip(TripHistory tripHistory);
    void addOrUpdateOrder(Order order);
}
