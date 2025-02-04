package com.brasileirao.championship.Controllers;

import com.brasileirao.championship.Entities.User;
import com.brasileirao.championship.Services.AuthenticationService;
import com.brasileirao.championship.Services.JwtService;
import com.brasileirao.championship.Services.LoginResponse;
import com.brasileirao.championship.dto.LoginUserDto;
import com.brasileirao.championship.dto.RegisterUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody RegisterUserDto userDto) {
        User resgiteredUser = authenticationService.signup(userDto);
        return ResponseEntity.ok(resgiteredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> autheticate(@RequestBody LoginUserDto userDto) {
        User authenticatedUser = authenticationService.authenticate(userDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
