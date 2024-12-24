package com.savior.forohub.controllers;

import com.savior.forohub.domain.user.AuthenticateUserDto;
import com.savior.forohub.domain.user.SignupRequest;
import com.savior.forohub.domain.user.User;
import com.savior.forohub.infrastructure.security.TokenJwtDto;
import com.savior.forohub.infrastructure.security.TokenService;
import com.savior.forohub.services.AuthService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> authUser(@RequestBody @Valid AuthenticateUserDto authenticateUserDto) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(authenticateUserDto.username(), authenticateUserDto.password());
        var userAuthenticated = authenticationManager.authenticate(authenticationToken);
        var JwtToken = tokenService.generateToken((User) userAuthenticated.getPrincipal());
        return ResponseEntity.ok(new TokenJwtDto(JwtToken));
    }

    @PostMapping(value = "/signup")
    @Transactional
    public void register(@RequestBody @Valid SignupRequest request) {
        authService.register(request);
    }
}