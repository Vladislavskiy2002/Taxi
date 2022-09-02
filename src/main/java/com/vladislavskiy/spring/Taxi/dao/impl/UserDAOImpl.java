package com.vladislavskiy.spring.Taxi.dao.impl;


import com.vladislavskiy.spring.Taxi.dao.UserDAO;
import com.vladislavskiy.spring.Taxi.entity.Order;
import com.vladislavskiy.spring.Taxi.entity.TripHistory;
import com.vladislavskiy.spring.Taxi.entity.User;
import com.vladislavskiy.spring.Taxi.exception_handling.NotFoundUserByIdException;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;


@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private EntityManager entityManager;

    //TODO: модифікатор +

    @Override
    public List<User> getAllUsers() {
        Session session = entityManager.unwrap(Session.class);
        List<User> userList = session.createQuery("from User", User.class).getResultList();
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
        if(session.get(User.class, id) == null)
            throw new NotFoundUserByIdException("Not Found User By Id : " + id);
        return session.get(User.class, id);
    }
    @Override
    public List<TripHistory> getAllTripHistoryFromCurrentUser(int id)
    {
        Session session = entityManager.unwrap(Session.class);
        if(session.get(User.class, id) == null)
            throw new NotFoundUserByIdException("Not Found User By Id : " + id);
         Query query = session.createQuery("select id from TripHistory where user_id =: current_id", Integer.class);
        query.setParameter("current_id", id);
         List<TripHistory> tripList = new ArrayList<>();
        List<Integer> tripIdList = query.getResultList();
         for(Integer tempId : tripIdList)
         {
             tripList.add(session.get(TripHistory.class,tempId));
         }
        //TODO : якщо неемає юзера треба 404 авератит +
        return tripList;
    }
    @Override
    public boolean addOrUpdateTrip(TripHistory tripHistory)
    {
        Session session = entityManager.unwrap(Session.class);
        session.save(tripHistory);
        return true;
    }
    //TODO : boolean +-
    @Override
    public boolean addOrUpdateOrder(Order order)
    {
        Session session = entityManager.unwrap(Session.class);
        session.save(order);
        //if(session.get(Order.class, order.getId()) == null)

        return true;
    }
    //TODO : boolean +-
    @Override
    public Order getOrderByUserId(int id)
    {
        Session session = entityManager.unwrap(Session.class);
        if(session.get(User.class, id) == null)
            throw new NotFoundUserByIdException("Not Found User By Id : " + id);
        Query query = session.createQuery("select id from Order where user_id =: current_id", Integer.class);
        query.setParameter("current_id", id);
        id = (Integer)query.getSingleResult();
        System.out.println(id);
        Order order = session.get(Order.class, id);
        return order;
    }
    public Order getOrderById(int id)
    {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Order.class, id);
    }
    public boolean isCurrentUsersOrderNull(Order order)
    {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select id from Order where user_id =: current_id", Integer.class);
        int id = order.getUser().getId();
        query.setParameter("current_id", id);
        if(query.getResultList().isEmpty())
        {
            System.out.println("true");
            System.out.println(query.getResultList());
            //TODO : Logger
            return true;
        }
        else
        {
            System.out.println("false");
            System.out.println(query.getResultList());
            //TODO : Logger

            return false;
        }
    }
    public void completeUsersOrder(Order order)
    {
        Session session = entityManager.unwrap(Session.class);
        order.setOrder_status(false);
        TripHistory tripHistory = new TripHistory(order.getComfort_level());
        tripHistory.setUser(order.getUser());
        addOrUpdateTrip(tripHistory);
        Query<Order> query = session.createQuery("delete from Order where user_id =: current_id");
        int id = order.getUser().getId();
        query.setParameter("current_id", id);
        query.executeUpdate();
    }
    public void deleteOrder(Order order)
    {
        Session session = entityManager.unwrap(Session.class);
        order.setOrder_status(false);
        Query<Order> query = session.createQuery("delete from Order where id =: current_id");
        int id = order.getId();
        query.setParameter("current_id", id);
        query.executeUpdate();
    }
}
