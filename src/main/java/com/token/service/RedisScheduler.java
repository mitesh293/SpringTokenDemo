package com.token.service;

import com.token.repository.UserJbdcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class RedisScheduler {

    @Autowired
    TaskExecutor taskExecutor;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserJbdcRepository userJbdcRepository;

    public void executeTask(){
        taskExecutor.execute(new MyRunnable(jdbcTemplate,userJbdcRepository));
    }
}
