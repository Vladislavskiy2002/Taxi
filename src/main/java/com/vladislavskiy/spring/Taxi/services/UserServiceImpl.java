package com.vladislavskiy.spring.Taxi.services;

import com.vladislavskiy.spring.Taxi.dao.UserDAO;
import com.vladislavskiy.spring.Taxi.entity.Order;
import com.vladislavskiy.spring.Taxi.entity.TripHistory;
import com.vladislavskiy.spring.Taxi.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    //TODO: винести више Transactional +
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    @Override
    public User getUser(int id)
    {
        return userDAO.getUser(id);
    }
    @Override
    public void addOrUpdateUser(User user)
    {
        userDAO.addOrUpdateUser(user);
    }
    @Override
    public List<User> getAllTripHistoryFromCurrentUser(int id)
    {
        return userDAO.getAllTripHistoryFromCurrentUser(id);
    }
    @Override
    public boolean addOrUpdateTrip(TripHistory tripHistory)
    {
        return userDAO.addOrUpdateTrip(tripHistory);
    }
    @Override
    public boolean addOrUpdateOrder(Order order)
    {
        return userDAO.addOrUpdateOrder(order);
    }
    @Override
    public Order getOrderByUserId(int id)
    {
        return userDAO.getOrderByUserId(id);
    }
    @Override
    public boolean isCurrentUsersOrderNull(Order order)
    {
        return userDAO.isCurrentUsersOrderNull(order);
    }
    @Override
    public void completeUsersOrder(Order order)
    {
        userDAO.completeUsersOrder(order);
    }
    @Override
    public void deleteOrder(Order order){userDAO.deleteOrder(order);}
    @Override
    public Order getOrderById(int id)
    {
        return userDAO.getOrderById(id);
    }
    public long countPriceForTrip(Order order)
    {
        String cheapStr = "CHEAP";
        String standartStr = "STANDART";
        String primeStr = "PRIME";

        long priceTripForOneKmLow = 2;
        //TODO: remove unused field +
        long priceTripForOneKmStandart = 3;
        long priceTripForOnekmPrime = 6;
        long distance;
        long tempCount = 0;
        if(order.getComfort_level().equals(cheapStr))
            tempCount = priceTripForOnekmPrime;
        else if(order.getComfort_level().equals(standartStr))
            tempCount = priceTripForOneKmStandart;
        else if(order.getComfort_level().equals(primeStr))
            tempCount = priceTripForOneKmLow;

        distance = (long)((Math.pow(order.getAddress().getXb() - order.getAddress().getXa(),2) + Math.pow((order.getAddress().getYb()) - order.getAddress().getYa(),2)));
        return tempCount * distance;
    }
    //TODO: перенести в сервіс +
    // TODO: позбутися мейджік намбер +
    //  TODO: і позбутися стрінг -
    public long countTimeForTrip(Order order)
    {
        long distance = (long)((Math.pow(order.getAddress().getXb() -order.getAddress().getXa(),2) + Math.pow((order.getAddress().getYb()) - order.getAddress().getYa(),2)));
        return distance/50;
    }
    @Override
    public String ordersInfo(Order order)
    {
        long price = countPriceForTrip(order);
        String str = String.format("Order's cost : %d\n", price);
        //TODO gfmtrl +
        long timeInHours = countTimeForTrip(order);
        str += "Order's Time : " + Long.toString(timeInHours) + "\n";
        return str;
    }
}
