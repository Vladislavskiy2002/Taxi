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
    public List<TripHistory> getAllTripHistoryFromCurrentUser(int id);
    public boolean addOrUpdateTrip(TripHistory tripHistory);
    public boolean addOrUpdateOrder(Order order);
    public Order getOrderByUserId(int id);
    public boolean isCurrentUsersOrderNull(Order order);
    public void completeUsersOrder(Order order);
    public void deleteOrder(Order order);
    public Order getOrderById(int id);
    public String ordersInfo(Order order);
}
