package com.token.service;

import com.token.Model.UserJdbc;
import com.token.repository.UserJbdcRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class MyRunnableTest {

    @InjectMocks
    MyRunnable myRunnable;

    @Mock
    JdbcTemplate jdbcTemplate;

    @Mock
    UserJbdcRepository userJbdcRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void run() {
        List<UserJdbc> userJdbcsList=new ArrayList<>();
        UserJdbc userJdbc=new UserJdbc();
        userJdbc.setId(1);
        userJdbc.setEmail("text@gmail.com");
        userJdbc.setName("junit 5 test");
        userJdbcsList.add(userJdbc);
        when(userJbdcRepository.findAll()).thenReturn(userJdbcsList);
        when(jdbcTemplate.queryForObject(anyString(),any(Object[].class),eq(String.class))).thenReturn("abc");
        myRunnable.run();
    }
}