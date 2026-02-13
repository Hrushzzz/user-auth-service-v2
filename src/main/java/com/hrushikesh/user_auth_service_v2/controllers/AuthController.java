package com.hrushikesh.user_auth_service_v2.controllers;

import com.hrushikesh.user_auth_service_v2.dtos.LoginRequestDTO;
import com.hrushikesh.user_auth_service_v2.dtos.SignUpRequestDTO;
import com.hrushikesh.user_auth_service_v2.dtos.UserDTO;
import com.hrushikesh.user_auth_service_v2.models.User;
import com.hrushikesh.user_auth_service_v2.services.IAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private IAuthService authService;  //

    // @Autowired can also be used
    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    /*
    bunch of APIs
    1. /signup
        -Type: POST
        -Request type
            -name
            -email
            -password
        -Return type
            -ResponseEntity
            -body: UserDTO
                -UserDTO
                    -name, email
            -200 if registration is success
            -error code if it fails
         -why ResponseEntity<UserDTO> instead of ResponseEntity<User>?

     */

    @PostMapping("/signup")
    ResponseEntity<UserDTO> signup(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        try {
            User user = authService.signup(signUpRequestDTO.getName(),
                    signUpRequestDTO.getEmail(),
                    signUpRequestDTO.getPassword());

            UserDTO userDTO = user.convertToUserDTO();
            return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return null;
        }
    }

    /*
    2. login
        -Type: POST
        -Return type
            -In response, headers
            -ResponseEntity<UserDTO>
                -headers(JWT)
            -name, email, roles
         -Request type
            -email, password

    /login GET
    -you're generating a token as a result of this call and the name
    suggests that you are only fetching some info
    -{
        "username":
        "password":
      }
      Request body / payload
     */

    @PostMapping("/login")
    ResponseEntity<UserDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        try {
            User user = authService.login(loginRequestDTO.getEmail(),
                    loginRequestDTO.getPassword());
            UserDTO userDTO = user.convertToUserDTO();
            return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return null;
        }
    }
}
