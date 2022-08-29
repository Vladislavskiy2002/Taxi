package com.vladislavskiy.spring.Taxi.dao;


import com.vladislavskiy.spring.Taxi.entity.Order;
import com.vladislavskiy.spring.Taxi.entity.TripHistory;
import com.vladislavskiy.spring.Taxi.entity.User;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
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
        return query.getResultList();
    }
    @Override
    public void addOrUpdateTrip(TripHistory tripHistory)
    {
        Session session = entityManager.unwrap(Session.class);
        session.save(tripHistory);
    }
    @Override
    public void addOrUpdateOrder(Order order)
    {
        Session session = entityManager.unwrap(Session.class);
        session.save(order);
    }
    @Override
    public Order getOrderByUserId(int id)
    {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Order.class, id);
    }
    public boolean isCurrentUsersOrderNull(Order order)
    {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select id from orders where user_id =: current_id", Integer.class);
        int id = order.getUser().getId();
        query.setParameter("current_id", id);
        if(query.getResultList().isEmpty())
        {
            System.out.println("true");
            System.out.println(query.getResultList());
            return true;
        }
        else
        {
            System.out.println("false");
            System.out.println(query.getResultList());
            return false;
        }
    }
    public void completeUsersOrder(Order order)
    {
        Session session = entityManager.unwrap(Session.class);
        order.setOrder_status(false);
        TripHistory tripHistory = new TripHistory(order.getComfort_level());
        tripHistory.addUserToTripHistory(order.getUser());
        addOrUpdateTrip(tripHistory);
        Query<Order> query = session.createQuery("delete from orders where user_id =: current_id");
        int id = order.getUser().getId();
        query.setParameter("current_id", id);
        query.executeUpdate();
    }
}
