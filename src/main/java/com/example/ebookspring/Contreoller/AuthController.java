package com.example.ebookspring.Contreoller;

import com.example.ebookspring.Dto.UserDto;
import com.example.ebookspring.Models.UserEntity;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.example.ebookspring.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthController {

    private final UserService userService;

// registration page
    @GetMapping("/register")
    public String getRegister(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);

        return "registerAndLogin/register";
    }

    @PostMapping("/register/save")
    public String postRegister(HttpSession session, @Valid @ModelAttribute("user") UserDto user,
                               BindingResult result, Model model) {
        UserEntity existingUserEmailEntity = userService.findByEmail(user.getEmail());
        if(existingUserEmailEntity != null && existingUserEmailEntity.getEmail() != null && !existingUserEmailEntity.getEmail().isEmpty()) {
            return "redirect:/register?fail";
        }

        UserEntity existingUserUserNameEntity = userService.findByUsername(user.getUsername());
        if(existingUserUserNameEntity != null && existingUserUserNameEntity.getUsername() != null && !existingUserUserNameEntity.getUsername().isEmpty()) {
            return "redirect:/register?fail";
        }

        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "registerAndLogin/register";
        }
        userService.saveUser(user);
        session.setAttribute("user", user);
        return "redirect:/login";
    }


    // login page
    @GetMapping("/login")
    public String getLogin(Model model) {
        return "registerAndLogin/login";
    }
}
