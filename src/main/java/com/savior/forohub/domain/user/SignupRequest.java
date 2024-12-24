package com.savior.forohub.domain.user;

import jakarta.validation.constraints.NotBlank;

public record SignupRequest(
        @NotBlank(message = "Username cannot be blank")
        String username,

        @NotBlank(message = "Password cannot be blank")
        String password
) {}
