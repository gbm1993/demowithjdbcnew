package com.example.demowithjdbcnew.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User u=new User();
        u.setId(resultSet.getInt(1));
        u.setName(resultSet.getString(2));
        u.setLname(resultSet.getString(3));
        u.setAge(resultSet.getInt(4));

        return u;
    }
}
