package com.example.Findaplace.controller;

import com.example.Findaplace.model.Users;
import com.example.Findaplace.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public List<Users> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }


    @GetMapping("/username/{user_name}")
    public Users getUserByUserName(@PathVariable String user_name) {
        return userService.getByUserName(user_name);
    }

    @PostMapping("")
    public void addUser(@RequestBody Users users) {
        userService.addUser(users);
    }


    @GetMapping("/followers/{id}")
    public List<Users> getAllFollowers(@PathVariable Long id) {
        return userService.findFollowersByUserId(id);}

    @GetMapping("/following/{id}")
    public List<Users> getAllFollowingUsers(@PathVariable Long id) {
        return userService.findFollowingByUserId(id);}



}
