package com.hrushikesh.user_auth_service_v2.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Role extends BaseModel {
    private String name;
}
