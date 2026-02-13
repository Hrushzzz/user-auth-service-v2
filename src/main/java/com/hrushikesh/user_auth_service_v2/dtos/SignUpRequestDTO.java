package com.hrushikesh.user_auth_service_v2.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SignUpRequestDTO {
    private String name;
    private String email;
    private String password;
}
