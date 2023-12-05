package com.manu.registrationloginsystem.repository;

import com.manu.registrationloginsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
