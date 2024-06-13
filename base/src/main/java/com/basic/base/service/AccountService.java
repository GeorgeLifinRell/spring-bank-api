package com.basic.base.service;

import com.basic.base.DTO.AccountDTO;
import com.basic.base.enums.acc_type;
import com.basic.base.enums.gender;
import com.basic.base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class AccountService {

    @Autowired
    private UserRepository UserRepository;

    public void CreateAccount(@RequestBody AccountDTO accountDTO) {

    }



}
