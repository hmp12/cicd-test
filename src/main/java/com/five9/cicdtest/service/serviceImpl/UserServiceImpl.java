package com.five9.cicdtest.service.serviceImpl;

import com.five9.cicdtest.entity.UserEntity;
import com.five9.cicdtest.repository.UserRepository;
import com.five9.cicdtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean addUser(UserEntity user) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        user.setCreatedDate(dateFormat.format(date));

        user.setStatus(1);

        userRepository.save(user);
        return true;
    }

    public boolean editUser(UserEntity user) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        user.setUpdatedDate(dateFormat.format(date));

        userRepository.save(user);
        return true;
    }

    public List<UserEntity> getAllUser() {
        List<UserEntity> userList = (List<UserEntity>) userRepository.findAll();
        return userList;
    }

    public Page<UserEntity> getUserList(String username, String email, String phone, int role, int status, String sortBy, int order, int page, int size) {
        Sort sort;

        if (order == 0) {
            sort = Sort.by(sortBy).ascending();
        } else {
            sort = Sort.by(sortBy).descending();
        }

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<UserEntity> userList = userRepository.findUserByFilter(username, email, phone, role, status, pageable);
        return userList;
    }

    public UserEntity getUserById(int id) {
        UserEntity user = userRepository.findUserById(id);
        return user;
    }

    public UserEntity getUserByUsername(String username) {
        UserEntity user = userRepository.findUserByUsername(username);
        return user;
    }

    public UserEntity getUserByEmail(String email) {
        UserEntity user = userRepository.findUserByEmail(email);
        return user;
    }

    public boolean deleteById(int id) {
        userRepository.deleteById(id);
        return true;
    }
}
