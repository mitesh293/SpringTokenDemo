package com.token.service;

import org.springframework.jdbc.core.JdbcTemplate;

public class MyRunnable implements Runnable {

    private final JdbcTemplate jdbcTemplate;

    public MyRunnable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run() {
        String newLastUpdateTime = jdbcTemplate.queryForObject("select * from dual",new Object[]{},String.class);
        System.out.println("Called... execute()"+newLastUpdateTime);
    }
}