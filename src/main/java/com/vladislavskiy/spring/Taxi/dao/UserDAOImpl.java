package com.vladislavskiy.spring.Taxi.dao;


import com.vladislavskiy.spring.Taxi.entity.User;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAOImpl{
    @Autowired
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        Session session = entityManager.unwrap(Session.class);
        List<User> userList = session.createQuery("from users", User.class).getResultList();
        return userList;
    }
    @Override
    public void addOrUpdateUser(User user)
    {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }
    @Override
    public User getUser(int id)
    {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, id);
    }
    @Override
    public List<User> getAllTripHistoryFromCurrentUser(int id)
    {
        Session session = entityManager.unwrap(Session.class);
         Query query = session.createQuery("select id from trip_information where user_id =: current_id", Integer.class);
        query.setParameter("current_id", id);
        System.out.println(query.getResultList());
        return null;
    }
    }
