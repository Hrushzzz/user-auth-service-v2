package com.hrushikesh.user_auth_service_v2.services;

import com.hrushikesh.user_auth_service_v2.models.User;

public interface IUserService {
    public User getUserById(Long id);
}
