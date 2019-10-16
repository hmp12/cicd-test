package com.five9.cicdtest.service;

import com.five9.cicdtest.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public boolean addUser(UserEntity user);

    public boolean editUser(UserEntity user);

    public List<UserEntity> getAllUser();

    public Page<UserEntity> getUserList(String username, String email, String phone, int role, int status, String sort, int order, int page, int size);

    public UserEntity getUserById(int id);

    public UserEntity getUserByUsername(String username);

    public UserEntity getUserByEmail(String email);

    public boolean deleteById(int id);
}
