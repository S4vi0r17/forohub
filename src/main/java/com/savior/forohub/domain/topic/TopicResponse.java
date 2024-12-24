package com.savior.forohub.domain.topic;

import java.time.LocalDate;

public record TopicResponse(
        Long id,
        String title,
        String message,
        LocalDate creationDate,
        String status,
        String author,
        String course
) { }
