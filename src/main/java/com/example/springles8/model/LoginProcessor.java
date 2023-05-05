package com.example.springles8.model;

import com.example.springles8.services.LoginCountService;
import com.example.springles8.services.LoginUserService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private final LoginUserService loginUserService;
    private final LoginCountService loginCountService;
    private String username;
    private String password;

    public LoginProcessor(LoginUserService loginUserService, LoginCountService loginCountService){
        this.loginUserService = loginUserService;
        this.loginCountService = loginCountService;
    }

    public boolean login(){
        loginCountService.increment();
        String username = this.getUsername();
        String password = this.getPassword();

        boolean loginResult = false;
        if ("admin".equals(username) && "pass".equals(password)){
            loginResult = true;
            loginUserService.setUsername(username);
            //return true;
        }/*else{
            return false;
        }*/
        return loginResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
