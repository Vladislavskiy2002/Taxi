package com.vladislavskiy.spring.Taxi.сontrollers;

import com.vladislavskiy.spring.Taxi.entity.Order;
import com.vladislavskiy.spring.Taxi.entity.TripHistory;
import com.vladislavskiy.spring.Taxi.entity.User;
import com.vladislavskiy.spring.Taxi.exception_handling.NotCorrectComfortLevelException;
import com.vladislavskiy.spring.Taxi.exception_handling.TooMuchOrdersForCurrentUserException;
import com.vladislavskiy.spring.Taxi.exception_handling.model.UserIncorrectData;
import com.vladislavskiy.spring.Taxi.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestController1 {
    @Autowired
    private UserServiceImpl userService;
//TODO: прайват +


    @GetMapping("/all_users")
    //TODO : all_users +
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/history/{id}")
    public List<TripHistory> getAllTripHistoryFromCurrentUser(@PathVariable int id) {
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
        tripHistory.setUser(user);
        userService.addOrUpdateTrip(tripHistory);
    }

    @PostMapping("/add/order")
    public void createOrder(@RequestBody Order order) {

        if (!userService.isCurrentUsersOrderNull(order)) {
            throw new TooMuchOrdersForCurrentUserException("Too Much Orders For Current User Exception");
        }
        System.out.println(order);
        System.out.println(order.getUser().getTripHistory());
        userService.addOrUpdateOrder(order);
    }

    @GetMapping("/get/infoAboutOrder/{id}")
    public String getInfoAboutOrder(@PathVariable int id) {
        Order order = userService.getOrderByUserId(id);

        //TODO : SERVIICE +
        return userService.ordersInfo(order);
    }

    @DeleteMapping("/completeUsersOrder/{id}")
    public boolean completeUsersOrder(@PathVariable int id) {
        //TODO return boolean +
        Order order = userService.getOrderByUserId(id);
        userService.completeUsersOrder(order);
        //TODO Fix Method +
        return true;
    }
}