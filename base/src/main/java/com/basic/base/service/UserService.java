package com.basic.base.service;

import com.basic.base.enums.acc_type;
import com.basic.base.model.User;
import com.basic.base.repository.UserRepository;
//import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.basic.base.enums.gender;
//@AllArgsConstructor
@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;

    public User registerUser(String username, String email, String password, gender gender, int phone_no, acc_type accType) {

        User user = new User();
        user.setuserName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setGender(gender);
        user.setPhone_no(phone_no);
        user.setAcc_type(accType);
        return UserRepository.save(user);
    }

    public User LoginUser(String username,String password) {
        User user = UserRepository.findByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}
