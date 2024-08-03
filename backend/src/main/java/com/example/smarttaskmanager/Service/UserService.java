package com.example.smarttaskmanager.Service;

import com.example.smarttaskmanager.Model.User;
import com.example.smarttaskmanager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(User user){
        user.setPassWord(passwordEncoder.encode(user.getPassWord()));
        return userRepository.save(user);
    }

    public User login(String userName){
        Optional<User> user = userRepository.findById(userName);
        //passwordEncoder.
        return user.orElse(null);
    }

    public User updatePassword(User userMod){
        return userRepository.findById(userMod.getUserName()).map(user -> {
            user.setUserName(userMod.getUserName());
            user.setPassWord(userMod.getPassWord());
            return userRepository.save(user);
        }).orElse(null);
    }

    public boolean deleteUser(String userName){
        return userRepository.findById(userName).map(user -> {
            userRepository.deleteById(userName);
            return true;
        }).orElse(false);
    }

}
