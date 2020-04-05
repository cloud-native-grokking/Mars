package com.cloudnative.grokking.mars.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import com.cloudnative.grokking.mars.dto.SampleMessage;

/**
 * @author vietdv272
 */
@Slf4j
//
@Service
public class SampleJmsSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String message) {
        log.info("Sending message -> {}", message);
        jmsTemplate.convertAndSend("sample-jms-queue", SampleMessage.builder()
                .content(message)
                .build());
    }

}
