package com.hrushikesh.user_auth_service_v2.services;

import com.hrushikesh.user_auth_service_v2.models.User;

public interface IAuthService {
    User signup(String name, String email, String password);
    User login(String email, String password);
}
