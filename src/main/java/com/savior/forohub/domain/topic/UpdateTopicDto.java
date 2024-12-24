package com.savior.forohub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateTopicDto(
        String title,
        String message,
        Status status,
        String author,
        String course
) { }
