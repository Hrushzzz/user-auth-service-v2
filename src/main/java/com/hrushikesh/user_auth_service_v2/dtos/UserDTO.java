package com.hrushikesh.user_auth_service_v2.dtos;

import com.hrushikesh.user_auth_service_v2.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private List<Role> roles;
}
