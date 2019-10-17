package com.five9.cicdtest.controller;


import com.five9.cicdtest.dto.UserLoginDTO;
import com.five9.cicdtest.entity.UserEntity;
import com.five9.cicdtest.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        List<UserEntity> userList = (List<UserEntity>) userService.getAllUser();
        return userList;
    }

    @GetMapping("/users")
    public Page<UserEntity> getUsers(
            @RequestParam(required = false, defaultValue = "") String username,
            @RequestParam(required = false, defaultValue = "") String email,
            @RequestParam(required = false, defaultValue = "") String phone,
            @RequestParam(required = false, defaultValue = "-1") int role,
            @RequestParam(required = false, defaultValue = "-1") int status,
            @RequestParam(required = false, defaultValue = "createdDate") String sort,
            @RequestParam(required = false, defaultValue = "0") int order,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "15") int size) {

        Page<UserEntity> userList = userService.getUserList(username, email, phone, role, status, sort, order, page, size);
        return userList;
    }

    @PostMapping("/add")
    public @ResponseBody
    Boolean addUser(@RequestBody UserEntity user) {
        userService.addUser(user);
        return true;
    }

    @PutMapping("/edit")
    public @ResponseBody
    Boolean editUser(@RequestBody UserEntity user) {
        userService.editUser(user);
        return true;
    }

    @GetMapping("/id/{id}")
    public @ResponseBody
    UserEntity getUserById(@PathVariable int id) {
        UserEntity user = userService.getUserById(id);
        return user;
    }

    @GetMapping("/username/{username}")
    public @ResponseBody
    UserEntity getUserByUsername(@PathVariable String username) {
        UserEntity user = userService.getUserByUsername(username);
        return user;
    }

    @GetMapping("/email/{email}")
    public @ResponseBody
    UserEntity getUserByEmail(@PathVariable String email) {
        UserEntity user = userService.getUserByEmail(email);
        return user;
    }

    @PutMapping("/delete")
    public @ResponseBody
    boolean deleteUser(@RequestBody int id) {
        userService.deleteById(id);
        return true;
    }
}
