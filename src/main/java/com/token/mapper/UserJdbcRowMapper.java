package com.token.mapper;

import com.token.Model.User;
import com.token.Model.UserJdbc;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserJdbcRowMapper implements RowMapper<UserJdbc>
{
    @Override
    public UserJdbc mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        UserJdbc user = new UserJdbc();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));

        return user;
    }
}
