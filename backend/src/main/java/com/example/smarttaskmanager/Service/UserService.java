package com.example.smarttaskmanager.Service;

import com.example.smarttaskmanager.Model.User;
import com.example.smarttaskmanager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }

    public String login(String userName, User userInfo){
        return userRepository.findById(userName).map( user -> {
            if(user.getPassWord().equals(userInfo.getPassWord())){
                return "Success";
            }
            return "Incorrect password";
        }).orElse("Username not found");
    }

    public String updatePassword(String userName, User userInfo){
        return userRepository.findById(userName).map(user -> {
            user.setPassWord(userInfo.getPassWord());
            userRepository.save(user);
            return "Success";
        }).orElse("Username not found");
    }

    public boolean deleteUser(String userName){
        return userRepository.findById(userName).map(user -> {
            userRepository.deleteById(userName);
            return true;
        }).orElse(false);
    }

}
