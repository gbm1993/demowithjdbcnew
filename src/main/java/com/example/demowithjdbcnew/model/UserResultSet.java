package com.example.demowithjdbcnew.model;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserResultSet  {

//    @Override
//    public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//        List<User> ulist= new ArrayList<>();
//        while (resultSet.next()) {
//            User u1 = new User();
//            u1.setId(resultSet.getInt(1));
//            u1.setName(resultSet.getString(2));
//            u1.setLname(resultSet.getString(3));
//            u1.setAge(resultSet.getInt(4));
//            ulist.add(u1);
//        }
//        return ulist;
//    }
}
