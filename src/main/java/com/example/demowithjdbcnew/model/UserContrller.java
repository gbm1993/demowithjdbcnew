package com.example.demowithjdbcnew.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping("details")
public class UserContrller {
    @Autowired
    private UserService userService;
    @PostMapping("add")
    public void insert2(@RequestBody User user){

        userService.insert(user);
    }
    @GetMapping("/delete/{id}")
    public void deletefromuser(@PathVariable("id") int id){
        userService.deletefromuser(id);

    }
    @PostMapping("update/{id}/{name}")
    public void updateuser(@PathVariable("id")int id,@PathVariable("name") String name){
        userService.updateuser(id,name);
    }
    @PostMapping("updatebyid/{name}/{lname}/{age}/{id}")
    public void  updateuserbyid(@PathVariable("name") String name,@PathVariable("lname")String lname,@PathVariable("age")int age,@PathVariable("id")int id){
        userService.updateuserbyid(name,lname,age,id);
    }
    @GetMapping("/data-beanproperty")
    public List<User> getdata(){
        return userService.getdata();
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/alldata")
    public List<User> getalldatas(){
        return userService.getalldata();
    }
    @GetMapping("/userdata")
    public List<User> getdetails(){
        return  userService.getdatausingresultsetextractor();
    }
}
