package com.codeghoul.usersevice.service;

import com.codeghoul.usersevice.dto.UserDepartmentResponse;
import com.codeghoul.usersevice.entity.User;

public interface UserService {

    User saveUser(User user);

    User getUserById(Long id);

    UserDepartmentResponse getUserWithDepartment(Long userId);
}
