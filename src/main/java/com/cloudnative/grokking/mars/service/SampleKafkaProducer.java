package com.cloudnative.grokking.mars.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.cloudnative.grokking.mars.dto.SampleMessage;
import com.cloudnative.grokking.mars.util.JsonUtils;

/**
 * @author vietdv272
 */
@Slf4j
//
@Service
public class SampleKafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("Producing message -> {}", message);
        kafkaTemplate.send("sample-topic", JsonUtils.printGson(SampleMessage.builder()
                .content(message)
                .build()));
    }
}
