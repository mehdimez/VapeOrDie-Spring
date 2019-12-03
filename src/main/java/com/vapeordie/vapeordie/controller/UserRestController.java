package com.vapeordie.vapeordie.controller;

import com.vapeordie.vapeordie.model.User;
import com.vapeordie.vapeordie.service.Account.AccountService;
import com.vapeordie.vapeordie.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class UserRestController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService ;
    @GetMapping("/list")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @PostMapping("/register")
    public User addUser(@RequestBody User user){
        return accountService.saveUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }
    @PutMapping("/update/{id}")
    public void updateUser(@Valid @RequestBody User user, @PathVariable("id") long id){
        userService.updateUser(user, id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
    }

}
