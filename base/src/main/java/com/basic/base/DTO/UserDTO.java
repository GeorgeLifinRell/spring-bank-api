package com.basic.base.DTO;

import com.basic.base.enums.gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.basic.base.enums.acc_type;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    @NotNull(message = "Username cannot be null")
    private String username;
    @Email(message = "Invalid email address")
    private String email;
    @NotNull(message = "Password cannot be null")
    private String Password;
    @NotNull(message = "Gender cannot be null")
    private gender gender;
    @NotNull(message = "Phone number cannot be null")
    private int phone_no;
    @NotNull(message = "Account type cannot be null")
    private acc_type acc_type;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public com.basic.base.enums.gender getGender() {
        return gender;
    }

    public void setGender(com.basic.base.enums.gender gender) {
        this.gender = gender;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public acc_type getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(acc_type acc_type) {
        this.acc_type = acc_type;
    }
}
