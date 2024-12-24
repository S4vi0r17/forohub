package com.savior.forohub.controllers;

import com.savior.forohub.domain.topic.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @SecurityRequirement(name = "bearer-key")
    @PostMapping
    @Transactional
    public ResponseEntity<TopicResponse> createTopic(@RequestBody @Valid CreateTopicDto topicRequest) {
        Topic topic = topicRepository.save(new Topic(topicRequest));
        return ResponseEntity.ok(new TopicResponse(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getStatus().name(),
                topic.getAuthor(),
                topic.getCourse()
        ));
    }

    @GetMapping
    public ResponseEntity<Page<TopicResponse>> listTopics(@PageableDefault(sort = {"creationDate"}, size = 10) Pageable pageable) {
        Page<Topic> topics = topicRepository.findAll(pageable);
        return ResponseEntity.ok(topics.map(topic -> new TopicResponse(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getStatus().name(),
                topic.getAuthor(),
                topic.getCourse()
        )));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponse> getTopic(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);

        return topic.map(value -> ResponseEntity.ok(new TopicResponse(
                value.getId(),
                value.getTitle(),
                value.getMessage(),
                value.getCreationDate(),
                value.getStatus().name(),
                value.getAuthor(),
                value.getCourse()
        ))).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @SecurityRequirement(name = "bearer-key")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicResponse> updateTopic(@PathVariable Long id, @RequestBody @Valid UpdateTopicDto updateTopicDto) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()) {
            topic.get().update(updateTopicDto);
            return ResponseEntity.ok(new TopicResponse(
                    topic.get().getId(),
                    topic.get().getTitle(),
                    topic.get().getMessage(),
                    topic.get().getCreationDate(),
                    topic.get().getStatus().name(),
                    topic.get().getAuthor(),
                    topic.get().getCourse()
            ));
        }
        return ResponseEntity.notFound().build();
    }

    @SecurityRequirement(name = "bearer-key")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()) {
            topicRepository.delete(topic.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
