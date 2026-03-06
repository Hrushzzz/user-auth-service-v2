package com.hrushikesh.user_auth_service_v2.services;

import com.hrushikesh.user_auth_service_v2.models.User;
import com.hrushikesh.user_auth_service_v2.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);

        if(optionalUser.isEmpty()){
            throw new RuntimeException("User with id " + id + " not found");
        }

        return optionalUser.get();
    }
}
