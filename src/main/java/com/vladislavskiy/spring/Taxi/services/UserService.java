package com.vladislavskiy.spring.Taxi.services;

import com.vladislavskiy.spring.Taxi.dao.UserDAO;
import com.vladislavskiy.spring.Taxi.entity.TripHistory;
import com.vladislavskiy.spring.Taxi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserServiceImpl {
    @Autowired
    private UserDAO userDAO;

    public UserService() {
    }

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    @Override
    @Transactional
    public User getUser(int id)
    {
        return userDAO.getUser(id);
    }
    @Override
    @Transactional
    public void addOrUpdateUser(User user)
    {
        userDAO.addOrUpdateUser(user);
    }
    @Override
    @Transactional
    public List<User> getAllTripHistoryFromCurrentUser(int id)
    {
        return userDAO.getAllTripHistoryFromCurrentUser(id);
    }
}
