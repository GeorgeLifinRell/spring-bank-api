package com.basic.base.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.basic.base.enums.AccountType;
import com.basic.base.enums.Gender;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String userName;
    private String email;
    private String password;
    private Gender gender;
    private String phoneNumber;
    private AccountType accountType;

}