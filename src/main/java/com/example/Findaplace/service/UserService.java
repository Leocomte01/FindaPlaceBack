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

    public List<Users> findAll(){
        return userDao.findAll();
    }

    public Optional<Users> getById(Long id){
        return userDao.findById(id);
    }

    public Users getConnexion(String user_name, String mdp){return userDao.getConnexion(user_name,mdp)
            .orElseThrow(RuntimeException::new);}

    public Users getByUserName(String userName){
        return userDao.getByUserName(userName);
    }

    public void addUser(Users users){
        userDao.save(users);
    }

    public List<Users> findFollowersByUserId(Long id){
       return userDao.findFollowers(id);
    }

    public List<Users> findFollowingByUserId(Long id){
        return userDao.findFollowingUsers(id);
    }


}
