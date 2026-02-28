package com.hrushikesh.user_auth_service_v2.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ValidateTokenDTO {
    private String token;
}

/*
{
    scope=[{id=1,
            createdAt=1770998221744,
             lastUpdatedAt=1770998221744,
             state=ACTIVE,
             name=DEFAULT}],
   iss=hrushikesh,
   exp=1771014569731,
   iat=1771004569731,
   userId=3}

 */
