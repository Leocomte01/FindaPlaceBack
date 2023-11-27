package com.example.Findaplace.service;

import com.example.Findaplace.DAO.UserDao;
import com.example.Findaplace.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    // Méthode pour récupérer tous les utilisateurs
    public List<Users> findAll() {
        return userDao.findAll();
    }

    // Méthode pour récupérer un utilisateur par son ID
    public Optional<Users> findById(Long id) {
        return userDao.findById(id);
    }

    // Méthode pour gérer la connexion d'un utilisateur
    public Users getConnexion(String user_name, String mdp) {
        return userDao.getConnexion(user_name, mdp)
                .orElseThrow(RuntimeException::new);
    }

    // Méthode pour récupérer un utilisateur par son pseudo
    public Users getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }

    // Méthode pour ajouter un nouvel utilisateur
    public void addUser(Users users) {
        userDao.save(users);
    }

    // Méthode pour récupérer la liste des utilisateurs qui suivent l'utilisateur avec l'ID spécifié
    public List<Users> findFollowersByUserId(Long id) {
        return userDao.findFollowers(id);
    }

    // Méthode pour récupérer la liste des utilisateurs suivis par l'utilisateur avec l'ID spécifié
    public List<Users> findFollowingByUserId(Long id) {
        return userDao.findFollowingUsers(id);
    }
}
