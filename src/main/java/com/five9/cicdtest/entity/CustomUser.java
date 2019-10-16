package com.five9.cicdtest.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

public class CustomUser extends User {
    private static final long serialVersionUID = 1L;

    public CustomUser(UserEntity user, List<GrantedAuthority> grantedAuthorityList) {
        super(user.getUsername(), user.getPassword(), grantedAuthorityList);
    }
}
