package com.example.Findaplace.controller;

import com.example.Findaplace.model.Users;
import com.example.Findaplace.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseBody
    @GetMapping("")
    public List<Users> getAllUsers() {
        return userService.findAll();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @ResponseBody
    @GetMapping("/{user_name}/{mdp}")
    public Users getConnexion(@PathVariable String user_name, @PathVariable String mdp){
        return userService.getConnexion(user_name, mdp);
    }


    @GetMapping("/username/{user_name}")
    public Users getUserByUserName(@PathVariable String user_name) {
        return userService.getByUserName(user_name);
    }

    @PostMapping("")
    public void addUser(@RequestBody Users users) {
        userService.addUser(users);
    }


    //récupère les personnes que le user dont on donne l'id suit
    //qui user{id} suit
    @GetMapping("/followers/{id}")
    public List<Users> getAllFollowers(@PathVariable Long id) {
        return userService.findFollowersByUserId(id);}

    //recupère les followers du user dont on donne l'id
    //quel user suit {id}
    @GetMapping("/following/{id}")
    public List<Users> getAllFollowingUsers(@PathVariable Long id) {
        return userService.findFollowingByUserId(id);}



}
