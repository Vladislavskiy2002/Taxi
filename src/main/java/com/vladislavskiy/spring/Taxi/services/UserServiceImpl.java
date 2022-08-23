package com.vladislavskiy.spring.Taxi.services;

import com.vladislavskiy.spring.Taxi.entity.TripHistory;
import com.vladislavskiy.spring.Taxi.entity.User;

import java.util.List;

public interface UserServiceImpl {
    List<User> getAllUsers();
    User getUser(int id);
    void addOrUpdateUser(User user);
    public List<User> getAllTripHistoryFromCurrentUser(int id);
}
