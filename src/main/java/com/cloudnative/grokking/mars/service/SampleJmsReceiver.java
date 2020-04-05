package com.cloudnative.grokking.mars.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import com.cloudnative.grokking.mars.dto.SampleMessage;
import com.cloudnative.grokking.mars.mapper.MessageMapper;
import com.cloudnative.grokking.mars.repository.MessageRepository;

/**
 * @author vietdv272
 */
@Slf4j
//
@Service
public class SampleJmsReceiver {

    @Autowired
    private MessageRepository messageRepository;

    @JmsListener(destination = "sample-jms-queue")
    public void receiveMessage(SampleMessage message) {
        log.info("Received message -> {}", message);

        messageRepository.save(MessageMapper.INSTANCE.to(message));
    }
}
