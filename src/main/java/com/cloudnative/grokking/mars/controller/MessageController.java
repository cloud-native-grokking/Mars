package com.cloudnative.grokking.mars.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cloudnative.grokking.mars.repository.MessageRepository;
import com.cloudnative.grokking.mars.service.SampleJmsSender;
import com.cloudnative.grokking.mars.service.SampleKafkaProducer;

@Slf4j
//
@RestController
@RequestMapping(value = "/sample")
public class MessageController {

    @Autowired
    private SampleKafkaProducer producer;
    @Autowired
    private SampleJmsSender sender;
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private MessageRepository messageRepository;

    @PostMapping
    public String sendMessage(@RequestParam("message") String message) {
        log.info("Invoked with message: {}", message);
        producer.sendMessage(message);
        sender.sendMessage(message);

        RBucket<String> cache = redissonClient.getBucket(message);
        if (cache.isExists()) {
            return cache.get();
        }

        String response = message + " -> pong";
        cache.set(response);
        return response;
    }

    @GetMapping
    public long count(@RequestParam("message") String message) {
        return messageRepository.countAllByContentContains(message);
    }
}