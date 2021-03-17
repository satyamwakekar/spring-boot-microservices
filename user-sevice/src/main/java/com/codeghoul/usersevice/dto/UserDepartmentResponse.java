package com.codeghoul.usersevice.dto;

import com.codeghoul.usersevice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDepartmentResponse {

    private User user;

    private Department department;
}
