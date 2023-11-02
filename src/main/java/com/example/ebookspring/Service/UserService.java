package com.example.ebookspring.Service;

import com.example.ebookspring.Models.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    void deleteBook(long userId);
}
