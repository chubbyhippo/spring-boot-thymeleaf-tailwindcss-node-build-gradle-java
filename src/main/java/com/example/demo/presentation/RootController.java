package com.example.demo.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class RootController {

    @GetMapping
    String index(Model model) {
        model.addAttribute("pageTitle", "Playing Thymeleaf");
        model.addAttribute("Chapters", List.of("Matthew",
                "Mark",
                "Luke",
                "John"));

        return "index";
    }
}
