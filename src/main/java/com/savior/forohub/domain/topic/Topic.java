package com.savior.forohub.domain.topic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Topic")
@Table(name = "topics")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String message;

    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String author;

    private String course;

    public Topic() { }

    public Topic(CreateTopicDto topicRequest) {
        this.title = topicRequest.title();
        this.message = topicRequest.message();
        this.creationDate = LocalDateTime.now();
        this.status = Status.ACTIVE;
        this.author = topicRequest.author();
        this.course = topicRequest.course();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public String getAuthor() {
        return author;
    }

    public String getCourse() {
        return course;
    }
}
