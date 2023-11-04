package com.example.ebookspring.Service.Impl;

import com.example.ebookspring.Dto.UserDto;
import com.example.ebookspring.Models.Role;
import com.example.ebookspring.Models.UserEntity;
import com.example.ebookspring.Repository.RoleRepository;
import com.example.ebookspring.Repository.UserRepository;
import com.example.ebookspring.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class UserImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    // Get all users
    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }


    // Delete UserEntity By Id
    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }


    // find user by Email
    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    //find by userName
    @Override
    public UserEntity findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }


    //save user
    @Override
    public void saveUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPhotourl(userDto.getPhotourl());
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByName("USER");
        userEntity.setRoles(Arrays.asList(role));
        userRepository.save(userEntity);
    }
}
