package com.hrushikesh.user_auth_service_v2.models;

import com.hrushikesh.user_auth_service_v2.dtos.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
public class User extends BaseModel {
    private String email;
    private String password;
    private String name;

    @ManyToMany
    private List<Role> roles;

    public UserDTO convertToUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(this.email);
        userDTO.setName(this.name);
        userDTO.setRoles(this.roles);
        userDTO.setId(this.getId());
        return userDTO;
    }
}
