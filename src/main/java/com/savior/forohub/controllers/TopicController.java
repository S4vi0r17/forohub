package com.savior.forohub.controllers;

import com.savior.forohub.domain.topic.CreateTopicDto;
import com.savior.forohub.domain.topic.Topic;
import com.savior.forohub.domain.topic.TopicRepository;
import com.savior.forohub.domain.topic.TopicResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicResponse> createTopic(@RequestBody CreateTopicDto topicRequest) {
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
}
