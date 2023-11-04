package com.example.ebookspring.Service;

import com.example.ebookspring.Dto.UserDto;
import com.example.ebookspring.Models.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAllUsers();
    void deleteUser(long userId);
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
    void saveUser(UserDto userDto);
}
