package com.vladislavskiy.spring.Taxi.services;

import com.vladislavskiy.spring.Taxi.dao.UserDAO;
import com.vladislavskiy.spring.Taxi.entity.TripHistory;
import com.vladislavskiy.spring.Taxi.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDAO userDAO) {
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

    @Transactional
    @Override
    public void addOrUpdateTrip(TripHistory tripHistory)
    {
        userDAO.addOrUpdateTrip(tripHistory);
    }
}
