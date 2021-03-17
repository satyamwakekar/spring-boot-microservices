package com.codeghoul.usersevice.controller;

import com.codeghoul.usersevice.dto.UserDepartmentResponse;
import com.codeghoul.usersevice.entity.User;
import com.codeghoul.usersevice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Trying to save user with first name {} in departmentId {}", user.getFirstName(), user.getDepartmentId());
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/department")
    public UserDepartmentResponse getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Trying to find user with department for userId {} ",userId);
        return userService.getUserWithDepartment(userId);
    }
}
