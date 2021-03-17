package com.codeghoul.usersevice.service.impl;

import com.codeghoul.usersevice.dto.Department;
import com.codeghoul.usersevice.dto.UserDepartmentResponse;
import com.codeghoul.usersevice.entity.User;
import com.codeghoul.usersevice.repository.UserRepository;
import com.codeghoul.usersevice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public User saveUser(User user) {
    log.info("Trying to insert user with first name {} and departmentId {}", user.getFirstName(),
        user.getDepartmentId());
    return userRepository.save(user);
  }

  @Override
  public User getUserById(Long id) {
    return userRepository.findByUserId(id);
  }

  @Override
  public UserDepartmentResponse getUserWithDepartment(Long userId) {
    log.info("Fetching user details for userId {}", userId);
    UserDepartmentResponse response = new UserDepartmentResponse();
    final User user = userRepository.findByUserId(userId);
    response.setUser(user);
    log.info("Fetching the department details for the departmentId {}", user.getDepartmentId());
    final Department department = restTemplate
        .getForObject("http://DEPARTMENTSERVICE/departments/" + user.getDepartmentId(), Department.class);
    response.setDepartment(department);
    return response;
  }
}
