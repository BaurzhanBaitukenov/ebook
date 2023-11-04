package com.example.ebookspring.Repository;

import com.example.ebookspring.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findFirstByUsername(String username);
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}
