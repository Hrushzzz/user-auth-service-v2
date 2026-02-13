package com.hrushikesh.user_auth_service_v2.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginRequestDTO {
    private String email;
    private String password;
}
