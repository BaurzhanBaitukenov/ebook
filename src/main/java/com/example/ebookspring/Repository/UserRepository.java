package com.example.ebookspring.Repository;

import com.example.ebookspring.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
