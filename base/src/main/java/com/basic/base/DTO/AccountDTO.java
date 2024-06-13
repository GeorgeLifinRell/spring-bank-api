package com.basic.base.DTO;

import com.basic.base.enums.acc_type;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import com.basic.base.enums.gender;

public class AccountDTO {
    @NotNull(message = "Username cannot be null")
    private String UserName;
    @Email(message = "Invalid email address")
    private String Email;
    @NotNull(message = "Phone Number cannot be null")
    private int phone_no;
    @NotNull(message = "Gender cannot be null")
    private gender gender;
    @NotNull(message = "Account type cannot be null")
    private acc_type acc_type;
    private int acc_no;
    private double balance;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public gender getGender() {
        return gender;
    }

    public void setGender(gender gender) {
        this.gender = gender;
    }

    public acc_type getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(acc_type acc_type) {
        this.acc_type = acc_type;
    }

    public double getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(int acc_no) {
        this.acc_no = acc_no;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

