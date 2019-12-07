package com.vapeordie.vapeordie.repository;

import com.vapeordie.vapeordie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUsersByEmail (String email);
    @Query(value = "SELECT u.* FROM `user` u,`user_roles` ur,`role` r WHERE r.id=ur.roles_id and ur.user_id_user=u.id_user and r.role_name = ?", nativeQuery = true)
    List<User> findUsers(String type);
}
