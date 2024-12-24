package com.savior.forohub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTopicDto(
        @NotBlank String title,
        @NotBlank String message,
        @NotBlank String author,
        @NotNull String course
) { }
