package com.example.Findaplace.DAO;

import com.example.Findaplace.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE u.user_name =:userName")
    Users getByUserName(String userName);

    @Query("SELECT u FROM Users u JOIN u.followerRelations f WHERE f.follower.id = :id ")
    List<Users> findFollowers(long id);

    @Query("SELECT u FROM Users u JOIN u.followerRelations f WHERE f.following.id = :id ")
    List<Users> findFollowingUsers(long id);

}
