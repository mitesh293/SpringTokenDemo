package com.token.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.core.task.TaskExecutor;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class RedisSchedulerTest {

    @InjectMocks
    RedisScheduler redisScheduler;

    @Mock
    TaskExecutor taskExecutor;

    @BeforeEach
    void setUp() {
    }

    @Test
    void executeTask() {
        doNothing().when(taskExecutor).execute(any(Runnable.class));
        redisScheduler.executeTask();
    }
}