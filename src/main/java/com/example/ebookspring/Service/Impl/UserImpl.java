package com.example.ebookspring.Service.Impl;

import com.example.ebookspring.Models.Book;
import com.example.ebookspring.Models.User;
import com.example.ebookspring.Repository.UserRepository;
import com.example.ebookspring.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserImpl implements UserService {

    private final UserRepository userRepository;


    // Get all users
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }


    // Delete User By Id
    @Override
    public void deleteBook(long userId) {
        userRepository.deleteById(userId);
    }
}
