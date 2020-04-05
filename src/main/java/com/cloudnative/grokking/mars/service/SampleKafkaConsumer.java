package com.cloudnative.grokking.mars.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.cloudnative.grokking.mars.dto.SampleMessage;
import com.cloudnative.grokking.mars.mapper.MessageMapper;
import com.cloudnative.grokking.mars.repository.MessageRepository;
import com.cloudnative.grokking.mars.util.JsonUtils;

@Slf4j
//
@Service
public class SampleKafkaConsumer {

    @Autowired
    private MessageRepository messageRepository;

    @KafkaListener(topics = "sample-topic", groupId = "sample-group-id")
    public void consume(String messageJson) {
        SampleMessage message = JsonUtils.parseGson(messageJson, SampleMessage.class);
        log.info("Consumed message -> {}", message);

        messageRepository.save(MessageMapper.INSTANCE.to(message));
    }
}