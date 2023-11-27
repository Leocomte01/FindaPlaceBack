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

    // Endpoint pour récupérer tous les utilisateurs
    @ResponseBody
    @GetMapping("")
    public List<Users> getAllUsers() {
        return userService.findAll();
    }

    // Endpoint pour récupérer un utilisateur par son ID
    @ResponseBody
    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    // Endpoint pour gérer la connexion d'un utilisateur
    @ResponseBody
    @GetMapping(value = "/{user_name}/{mdp}", produces = "application/json")
    public Users getConnexion(@PathVariable String user_name, @PathVariable String mdp) {
        return userService.getConnexion(user_name, mdp);
    }

    // Endpoint pour récupérer un utilisateur par son nom d'utilisateur
    @GetMapping("/username/{user_name}")
    public Users getUserByUserName(@PathVariable String user_name) {
        return userService.getByUserName(user_name);
    }

    // Endpoint pour ajouter un nouvel utilisateur
    @PostMapping("")
    public void addUser(@RequestBody Users users) {
        userService.addUser(users);
    }

    // Endpoint pour récupérer tous les followers d'un utilisateur par son ID
    @GetMapping("/followers/{id}")
    public List<Users> getAllFollowers(@PathVariable Long id) {
        return userService.findFollowersByUserId(id);
    }

    // Endpoint pour récupérer tous les utilisateurs suivis par un utilisateur par son ID
    @GetMapping("/following/{id}")
    public List<Users> getAllFollowingUsers(@PathVariable Long id) {
        return userService.findFollowingByUserId(id);
    }
}
