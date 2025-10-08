package com.example.Journal.controller;

import com.example.Journal.Entity.UserEntry;
import com.example.Journal.Repository.UserRepository;
import com.example.Journal.Service.UserService;
import com.example.Journal.Service.WeatherService;
import com.example.Journal.apiResponce.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserEntry user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserEntry userInDb = userService.findByUserName(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewEntry(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteByUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName ( authentication.getName());
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @GetMapping
    public ResponseEntity<?> greetAll(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponce = weatherService.getWeather("Mumbai");
        String greeting = "" ;
        if (weatherResponce != null){
            greeting = "weathers feels like " + weatherResponce.getCurrent().getFeelslike();
        }
       return  new ResponseEntity<>("hi"+ authentication.getName() + greeting, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findtAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<UserEntry> all = userService.findAll();
        if (all != null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
