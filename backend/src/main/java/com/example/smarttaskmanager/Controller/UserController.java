package com.example.smarttaskmanager.Controller;

import com.example.smarttaskmanager.Model.User;
import com.example.smarttaskmanager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> register(@RequestBody User user){
        User userNew = userService.register(user);
        return ResponseEntity.ok(userNew);
    }

}
