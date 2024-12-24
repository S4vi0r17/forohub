package com.savior.forohub.controllers;

import com.savior.forohub.domain.topic.CreateTopicDto;
import com.savior.forohub.domain.topic.Topic;
import com.savior.forohub.domain.topic.TopicRepository;
import com.savior.forohub.domain.topic.TopicResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

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
}
