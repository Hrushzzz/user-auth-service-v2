package com.hrushikesh.user_auth_service_v2.pojos;

import com.hrushikesh.user_auth_service_v2.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserToken {

    private User user;
    private String token;

    public UserToken(User user, String token) {
        this.user = user;
        this.token = token;
    }
}
