package com.example.diningreviews.controller;

import com.example.diningreviews.entity.*;
import com.example.diningreviews.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DiningreviewsController {

    private final DiningreviewsRepository diningreviewsRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public DiningreviewsController(
            final DiningreviewsRepository diningreviewsRepository,
            final RestaurantRepository restaurantRepository,
            final UserRepository userRepository)
    {
        this.diningreviewsRepository = diningreviewsRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String testApp(){
        return "Hello Welcome to the Dining Review Application";
    }

    @GetMapping("/users")
    public Iterable<User> getAllDiningreviews(){
        return this.userRepository.findAll();
    }
}
