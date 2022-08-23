package com.vladislavskiy.spring.Taxi.Controllers;

import com.vladislavskiy.spring.Taxi.entity.TripHistory;
import com.vladislavskiy.spring.Taxi.entity.User;
import com.vladislavskiy.spring.Taxi.services.UserService;
import com.vladislavskiy.spring.Taxi.services.UserServiceImpl;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestController1 {
    @Autowired
    UserService userService;
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
    @PostMapping("/add/addMessageToUser/{id}")
    public void addMessageToUser(@PathVariable int id,@RequestBody String message)
    {
        User user = userService.getUser(id);
        TripHistory tripHistory = new TripHistory(message);
        user.addTripForUser(tripHistory);
        tripHistory.setUser(user);
        userService.addOrUpdateUser(user);
        System.out.println(message);
    }
}
