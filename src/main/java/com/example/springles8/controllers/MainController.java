package com.example.springles8.controllers;

import com.example.springles8.services.LoginCountService;
import com.example.springles8.services.LoginUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoginCountService loginCountService;
    private final LoginUserService loginUserService;

    public MainController(LoginUserService loginUserService, LoginCountService loginCountService){
        this.loginUserService = loginUserService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout, Model model){

        if (logout != null){
            loginUserService.setUsername(null);
        }

        String username = loginUserService.getUsername();
        int count = loginCountService.getCount();
        if (username == null){
            return "redirect:/";
        }

        model.addAttribute("username", username);
        model.addAttribute("loginCount", count);
        return "main.html";
    }

}
