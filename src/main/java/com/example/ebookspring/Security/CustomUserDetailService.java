package com.example.ebookspring.Security;

import com.example.ebookspring.Repository.UserRepository;
import lombok.AllArgsConstructor;
import com.example.ebookspring.Models.UserEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findFirstByUsername(username);
        if(userEntity != null) {
            User authUser = new User(
                    userEntity.getEmail(),
                    userEntity.getPassword(),
                    userEntity.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList())
            );
            return authUser;
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }
}
