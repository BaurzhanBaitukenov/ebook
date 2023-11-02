package com.example.ebookspring.Contreoller;

import com.example.ebookspring.Models.User;
import com.example.ebookspring.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;


    // get All users
    @GetMapping()
    public String getAllUsers(Model model) {
        List<User> users = userService.findAllUsers();

        model.addAttribute("users", users);
        return "user/user-list";
    }


    // delete user
    @GetMapping("/{userId}/delete")
    public String deleteUserById(@PathVariable("userId") long userId) {
        userService.deleteBook(userId);
        return "redirect:/users";
    }
}
