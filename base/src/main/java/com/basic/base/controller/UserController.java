package com.basic.base.controller;

import com.basic.base.DTO.UserDTO;
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
    public ResponseEntity<User> register(@RequestBody UserDTO user) {
        User registeredUser = userService.registerUser(user.getUsername(), user.getEmail(), user.getPassword(),user.getGender(),user.getPhone_no(),user.getAcc_type());
        accountService.CreateAccount(registeredUser.getuserName(), registeredUser.getEmail(), registeredUser.getPhone_no(), registeredUser.getGender(), registeredUser.getAcc_type()); // Assuming a default savings account
        return ResponseEntity.ok(registeredUser);
    }
    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User loggedInUser = userService.LoginUser(user.getuserName(), user.getPassword());
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        }
        return ResponseEntity.status(401).build();
    }
}