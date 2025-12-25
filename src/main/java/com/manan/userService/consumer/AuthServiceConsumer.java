package com.manan.userService.consumer;

import com.manan.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class AuthServiceConsumer {
    private UserRepository userRepository;

    @Autowired
    AuthServiceConsumer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "spring.kafka.topic-json.name", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(Object eventData) {
        try {
        int x = 10, y = 10;
        int z = x+y;
        } catch(Exception ex) {
            System.out.println("error");
        }
    }
}
