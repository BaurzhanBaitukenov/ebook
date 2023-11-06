package com.example.ebookspring.Contreoller;

import com.example.ebookspring.Models.UserEntity;
import com.example.ebookspring.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;


    // get All users
    @GetMapping()
    public String getAllUsers(Model model) {
        List<UserEntity> userEntities = userService.findAllUsers();

        model.addAttribute("users", userEntities);
        return "user/user-list";
    }


    // delete user
    @GetMapping("/users/{userId}/delete")
    public String deleteUserById(@PathVariable("userId") long userId) {
        userService.deleteUser(userId);
        return "redirect:/users";
    }

    @GetMapping("/profile/{email}")
    public String getUserPage(@PathVariable("email") String email, Model model) {
        UserEntity user = userService.findByEmail(email);
        model.addAttribute("user", user);
        return "user/user-profile";
    }
}
