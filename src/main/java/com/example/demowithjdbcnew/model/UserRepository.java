package com.example.demowithjdbcnew.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertintoUser(User user){
        String query="insert into student(id,name,lname,age) values(?,?,?,?)";

        int i=jdbcTemplate.update(query,new Object[]{user.getId(),user.getName(),user.getLname(),user.getAge()});
        System.out.println("Inserted :"+i);
    }
    public void deletefromuser(int id) {
        String query="delete from student where id=?";
        int i= jdbcTemplate.update(query,new Object[]{id});
        System.out.println("Record deleted"+i);
    }

    public void updateuser(int id,String name){
        String query="update student set id=? where name=? ";
        int i=jdbcTemplate.update(query,new Object[]{id,name});
        System.out.println("Record updated"+i);
    }
    public void  updateuserbyid(String name,String lname,int age,int id){
        String query="update student set name=?,lname=?,age=? where id=?";
        int i=jdbcTemplate.update(query,new Object[]{name,lname,age,id,});
        System.out.println("Record updated"+i);
    }
    public List<User> getalldata(){
        String query="select * from student";
        List<User> list=jdbcTemplate.query(query,new BeanPropertyRowMapper<>(User.class));
        return list;
    }
    public List<User> getalldatausingrowmapper(){
        String query="select * from student";
        List<User> list=jdbcTemplate.query(query, new UserRowMapper() );
        return list;
    }
    public List<User> getalldatausingresultsetextractor(){
        String query="select * from student";
        List<User> list=  jdbcTemplate.query(query, new ResultSetExtractor<List<User>>() {
            @Override
            public List<User> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
               List<User> userList=new ArrayList<>();
               while (resultSet.next()){

                   User u2=new User();
                   u2.setId(resultSet.getInt(1));
                   u2.setName(resultSet.getString(2));
                   u2.setLname(resultSet.getString(3));
                   u2.setAge(resultSet.getInt(4));
                   userList.add(u2);
               }


                return userList;
            }
        });

        return list;
    }
}
