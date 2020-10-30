package com.token.repository;

import com.token.Model.User;
import com.token.Model.UserJdbc;
import com.token.mapper.UserJdbcRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserJbdcRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public List<UserJdbc> findAll() {
        return jdbcTemplate.query("select * from users", new UserJdbcRowMapper());
    }
}
