package com.example.Findaplace.DAO;

import com.example.Findaplace.model.Users;
import com.example.Findaplace.model.FollowingRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FollowingRelationDAO extends JpaRepository<FollowingRelation, Long> {

        void deleteByFollowerAndFollowing(Users follower, Users following);

}
