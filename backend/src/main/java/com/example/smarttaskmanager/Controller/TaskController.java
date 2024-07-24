package com.example.smarttaskmanager.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @GetMapping("/hello")
    public String sample() {
        return "helloworld";
    }
}
