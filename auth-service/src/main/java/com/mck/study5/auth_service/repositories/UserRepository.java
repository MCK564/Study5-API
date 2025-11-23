package com.mck.study5.auth_service.repositories;

import com.mck.study5.auth_service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Boolean existsByEmailOrUsername(String email, String username);
    Optional<User> findByUsername(String username);
}
