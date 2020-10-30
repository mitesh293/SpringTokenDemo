package com.token.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class JedisServiceTest {

    @InjectMocks
    private JedisService jedisService;

    @Test
    void deleteValueFromSet() {
        jedisService.deleteValueFromSet("Radis","comumn","21","user");
    }
}