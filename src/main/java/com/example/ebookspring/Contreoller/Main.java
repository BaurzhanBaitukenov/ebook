package com.example.ebookspring.Contreoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main {

    @GetMapping("/")
    public String helloW() {
        return "home/main";
    }
}
