package com.token.service;

import com.token.Model.UserJdbc;
import com.token.repository.UserJbdcRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MyRunnable implements Runnable {

    private final JdbcTemplate jdbcTemplate;

    private final UserJbdcRepository userJbdcRepository;

    public MyRunnable(JdbcTemplate jdbcTemplate, UserJbdcRepository userJbdcRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userJbdcRepository = userJbdcRepository;
    }

    @Override
    public void run() {
        List<UserJdbc> allUserJdbcList = userJbdcRepository.findAll();
        System.out.println("Called... run(), User List size:: "+allUserJdbcList.size());
    }
}