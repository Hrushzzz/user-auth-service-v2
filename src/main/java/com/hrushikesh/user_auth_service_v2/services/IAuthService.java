package com.hrushikesh.user_auth_service_v2.services;

import com.hrushikesh.user_auth_service_v2.models.User;
import com.hrushikesh.user_auth_service_v2.pojos.UserToken;

public interface IAuthService {
    User signup(String name, String email, String password);
    UserToken login(String email, String password);
    Boolean validateToken(String token);
}
