package com.hrushikesh.user_auth_service_v2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Session extends BaseModel {

    private String token;

    @ManyToOne
    private User user;
}

/*
Session User => M : 1
1        1
M        1
*/
