package com.vladislavskiy.spring.Taxi.сontrollers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.vladislavskiy.spring.Taxi.dao.UserDAO;
import com.vladislavskiy.spring.Taxi.entity.Address;
import com.vladislavskiy.spring.Taxi.entity.Order;
import com.vladislavskiy.spring.Taxi.entity.TripHistory;
import com.vladislavskiy.spring.Taxi.entity.User;
import com.vladislavskiy.spring.Taxi.exception_handling.TooMuchOrdersForCurrentUserException;
import com.vladislavskiy.spring.Taxi.exception_handling.UserIncorrectData;
import com.vladislavskiy.spring.Taxi.services.UserService;
import com.vladislavskiy.spring.Taxi.services.UserServiceImpl;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        if(!userService.isCurrentUsersOrderNull(order))
        {
            throw new TooMuchOrdersForCurrentUserException("Too Much Orders For Current User Exception");
        }
        System.out.println(order);
        System.out.println(order.getUser().getTripHistory());
        userService.addOrUpdateOrder(order);
    }
    @ExceptionHandler
    public ResponseEntity<UserIncorrectData>hendlerException(TooMuchOrdersForCurrentUserException exception)
    {
        UserIncorrectData data = new UserIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get/infoOfUsersTrip/{id}")
    public void getInfoOfUsersTrip(@PathVariable int id) {
        Order order = userService.getOrderByUserId(id);

    }
    @GetMapping("/get/infoAboutOrder/{id}")
    public String getInfoAboutOrder(@PathVariable int id) {
        Order order = userService.getOrderByUserId(id);
        Long price = order.countPriceForTrip();
        String str = "Order's cost : " + price.toString() + "\n";
        Long timeInHours = order.countTimeForTrip();
        str += "Order's Time : " + timeInHours.toString() + "\n";
        return str;
    }
    @DeleteMapping("/get/completeUsersOrder/{id}")
    public void completeUsersOrder(@PathVariable int id) {
        Order order = userService.getOrderByUserId(id);
        System.out.println(order);
        userService.completeUsersOrder(order);
    }
}