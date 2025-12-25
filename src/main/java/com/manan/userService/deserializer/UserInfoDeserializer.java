package com.manan.userService.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manan.userService.entities.UserInfoDto;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.ByteBuffer;
import java.util.Map;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public UserInfoDto deserialize(String s, byte[] bytes) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserInfoDto user = null;
        try {
            user = objectMapper.readValue(bytes, UserInfoDto.class);
        } catch(Exception ex) {
            System.out.println("Not able to deserialize");
        }
        return user;
    }

    @Override
    public UserInfoDto deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public UserInfoDto deserialize(String topic, Headers headers, ByteBuffer data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
