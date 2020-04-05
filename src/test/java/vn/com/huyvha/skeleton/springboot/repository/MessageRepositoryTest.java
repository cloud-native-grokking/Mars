package com.cloudnative.grokking.mars.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.cloudnative.grokking.mars.SpringbootSkeleton;
import com.cloudnative.grokking.mars.entity.Message;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author vietdv272
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = SpringbootSkeleton.class)
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testCountMessageByContent() {
        // GIVEN
        messageRepository.save(Message.builder()
                .content("jpa")
                .build());
        messageRepository.save(Message.builder()
                .content("hibernate")
                .build());
        messageRepository.save(Message.builder()
                .content("jdbc")
                .build());

        // WHEN
        long result = messageRepository.countAllByContentContains("a");

        // THEN
        assertThat(result, is(2L));
    }
}