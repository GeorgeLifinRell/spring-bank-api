package com.basic.base.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.basic.base.enums.AccountType;
import com.basic.base.enums.Gender;
import com.basic.base.enums.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User implements UserDetails {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private Gender gender;
    private String phoneNumber;
    private AccountType accountType;
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List.of(new SimpleGrantedAuthority(role.name()));
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return username;
    }
}