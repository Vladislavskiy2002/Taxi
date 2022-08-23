package com.vladislavskiy.spring.Taxi.dao;

import com.vladislavskiy.spring.Taxi.entity.TripHistory;
import com.vladislavskiy.spring.Taxi.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUser(int id);
    void addOrUpdateUser(User user);
    List<User> getAllTripHistoryFromCurrentUser(int id);

}


