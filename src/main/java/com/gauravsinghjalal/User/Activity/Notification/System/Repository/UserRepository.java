package com.gauravsinghjalal.User.Activity.Notification.System.Repository;

import com.gauravsinghjalal.User.Activity.Notification.System.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmail(String email);

}
