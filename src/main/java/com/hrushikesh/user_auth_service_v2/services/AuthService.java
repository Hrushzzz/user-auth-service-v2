package com.hrushikesh.user_auth_service_v2.services;

import com.hrushikesh.user_auth_service_v2.exceptions.IncorrectPasswordException;
import com.hrushikesh.user_auth_service_v2.exceptions.UserAlreadyExistsException;
import com.hrushikesh.user_auth_service_v2.exceptions.UserNotRegisteredException;
import com.hrushikesh.user_auth_service_v2.models.Role;
import com.hrushikesh.user_auth_service_v2.models.State;
import com.hrushikesh.user_auth_service_v2.models.User;
import com.hrushikesh.user_auth_service_v2.repositories.RoleRepo;
import com.hrushikesh.user_auth_service_v2.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public User signup(String name, String email, String password) {
        /*
        every user should register with a unique email
         */
        Optional<User> OptionalUser = userRepo.findByEmail(email);
        if (OptionalUser.isPresent()) {
            throw new UserAlreadyExistsException("User already exists, try with a new Email");
        }

        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setCreatedAt(new Date());
        user.setLastUpdatedAt(new Date());
        user.setState(State.ACTIVE);

         /*
        Be default, user role is DEFAULT
         */
        Role role;
        Optional<Role> OptionalRole = roleRepo.findByName("DEFAULT");
        if (OptionalRole.isEmpty()) {
            role = new Role();
            role.setName("DEFAULT");
            role.setCreatedAt(new Date());
            role.setLastUpdatedAt(new Date());
            role.setState(State.ACTIVE);
            roleRepo.save(role);
        } else {
            role = OptionalRole.get();
        }

        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);

        return userRepo.save(user);
    }

    @Override
    public User login(String email, String password) {
        Optional<User> OptionalUser = userRepo.findByEmail(email);
        if (OptionalUser.isEmpty()) {
            throw new UserNotRegisteredException("The User is not registered. Please register");
        }

        User user = OptionalUser.get();
        if (password.equals(user.getPassword())) {
            return user;
        } else {
            throw new IncorrectPasswordException("Password is incorrect");
        }
    }
}

// Store the password into DB in encrypted format
