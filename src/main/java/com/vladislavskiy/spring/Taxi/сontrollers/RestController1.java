package com.vladislavskiy.spring.Taxi.сontrollers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.vladislavskiy.spring.Taxi.dao.UserDAO;
import com.vladislavskiy.spring.Taxi.entity.Address;
import com.vladislavskiy.spring.Taxi.entity.Order;
import com.vladislavskiy.spring.Taxi.entity.TripHistory;
import com.vladislavskiy.spring.Taxi.entity.User;
import com.vladislavskiy.spring.Taxi.services.UserService;
import com.vladislavskiy.spring.Taxi.services.UserServiceImpl;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestController1 {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/allusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/history/{id}")
    public List<User> getAllTripHistoryFromCurrentUser(@PathVariable int id) {
        return userService.getAllTripHistoryFromCurrentUser(id);
    }

    @PostMapping("/add/newuser")
    public void addUser(@RequestBody User user) {
        userService.addOrUpdateUser(user);
    }

    @PostMapping("/add/MessageToUser/{id}")
    public void addMessageToUser(@PathVariable int id, @RequestBody String message) {
        System.out.println(message);
        User user = userService.getUser(id);
        TripHistory tripHistory = new TripHistory(message);
        tripHistory.addUserToTripHistory(user);
        userService.addOrUpdateTrip(tripHistory);
    }

    @PostMapping("/add/order")
    public void createOrder(@RequestBody Order order) {
        System.out.println(order);


        Order order2 = new Order();



        Address address = new Address();
        order2.setAddress(address);
        order2.getAddress().setXa(1l);
        order2.getAddress().setXb(2l);
        order2.getAddress().setYa(3l);
        order2.getAddress().setYb(4l);
        System.out.println(order2.getAddress());

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            String json = ow.writeValueAsString(order2);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(order.getUser().getTripHistory());
        userService.addOrUpdateOrder(order);
    }

    @GetMapping("/get/infoOfUsersTrip/{id}")
    public void getInfoOfUsersTrip(@PathVariable int id) {
        Order order = userService.getOrderByUserId(id);

    }
}