package com.savior.forohub.domain.user;

public record AuthenticateUserDto(
        String username,
        String password
) { }
