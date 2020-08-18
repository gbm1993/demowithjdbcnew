package com.example.demowithjdbcnew.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void insert(User user){
        userRepository.insertintoUser(user);

    }
    public void deletefromuser(int id){
        userRepository.deletefromuser(id);
    }
    public void updateuser(int id,String name){
        userRepository.updateuser(id,name);
    }
    public void  updateuserbyid(String name,String lname,int age,int id){
        userRepository.updateuserbyid(name,lname,age,id);
    }
    public List<User> getdata(){
        return userRepository.getalldata();
    }
    public List<User> getalldata(){
        return userRepository.getalldatausingrowmapper();
    }
    public List<User> getdatausingresultsetextractor(){
        return userRepository.getalldatausingresultsetextractor();
    }
}
