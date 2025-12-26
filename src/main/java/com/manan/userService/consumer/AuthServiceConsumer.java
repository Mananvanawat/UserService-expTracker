package com.manan.userService.consumer;

import com.manan.userService.entities.UserInfo;
import com.manan.userService.entities.UserInfoDto;
import com.manan.userService.repository.UserRepository;
import com.manan.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceConsumer {
    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public AuthServiceConsumer(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(UserInfoDto eventData) {
        try {
       userService.createOrUpdateUser(eventData);
        } catch(Exception ex) {
            System.out.println("error");
        }
    }
}
