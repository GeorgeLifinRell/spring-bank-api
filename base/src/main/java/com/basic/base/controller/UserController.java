package com.basic.base.controller;

import com.basic.base.DTO.UserDTO;
import com.basic.base.model.Account;
import com.basic.base.model.User;
import com.basic.base.service.UserService;
import com.basic.base.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody UserDTO user) {
        User registeredUser = userService.registerUser(user.getUsername(), user.getEmail(), user.getPassword(),
                user.getGender(), user.getPhoneNumber(), user.getAccountType());
        Account newAccount = accountService.createAccount(registeredUser.getUsername(), registeredUser.getEmail(),
                registeredUser.getPhoneNumber(), registeredUser.getGender(), registeredUser.getAccountType()); // Assuming
                                                                                                               // a
                                                                                                               // default
                                                                                                               // savings
                                                                                                               // account
        return ResponseEntity.ok(newAccount);
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User loggedInUser = userService.LoginUser(user.getUsername(), user.getPassword());
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        }
        return ResponseEntity.status(401).build();
    }
}