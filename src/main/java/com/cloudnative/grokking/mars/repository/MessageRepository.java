package com.cloudnative.grokking.mars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cloudnative.grokking.mars.entity.Message;

/**
 * @author vietdv272
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    long countAllByContentContains(String text);
}
