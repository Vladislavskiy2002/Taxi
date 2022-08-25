package com.vladislavskiy.spring.Taxi.сontrollers;

import com.vladislavskiy.spring.Taxi.dao.UserDAO;
import com.vladislavskiy.spring.Taxi.entity.Order;
import com.vladislavskiy.spring.Taxi.entity.TripHistory;
import com.vladislavskiy.spring.Taxi.entity.User;
import com.vladislavskiy.spring.Taxi.services.UserService;
import com.vladislavskiy.spring.Taxi.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestController1 {
    @Autowired
    UserServiceImpl userService;
    @GetMapping("/allusers")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
    @GetMapping("/history/{id}")
    public List<User> getAllTripHistoryFromCurrentUser(@PathVariable int id)
    {
        return userService.getAllTripHistoryFromCurrentUser(id);
    }
    @PostMapping("/add/newuser")
    public void addUser(@RequestBody User user)
    {
        TripHistory tripHistory = new TripHistory("A-B");
        user.addTripForUser(tripHistory);
        tripHistory.setUser(user);
        userService.addOrUpdateUser(user);
    }
    @PostMapping("/add/MessageToUser/{id}")
    public void addMessageToUser(@PathVariable int id,@RequestBody String message)
    {
        System.out.println(message);
        User user = userService.getUser(id);
        TripHistory tripHistory = new TripHistory(message);
        tripHistory.addUserToTripHistory(user);
        userService.addOrUpdateTrip(tripHistory);
    }
    @PostMapping("/add/order")
    public void createOrder(@RequestBody Order order)
    {
        userService.addOrUpdateOrder(order);
    }
}
