package com.savior.forohub.domain.topic;

import java.time.LocalDateTime;

public record TopicResponse(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        String status,
        String author,
        String course
) { }
