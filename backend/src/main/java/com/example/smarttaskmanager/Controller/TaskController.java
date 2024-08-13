package com.example.smarttaskmanager.Controller;

import com.example.smarttaskmanager.Model.Task;
import com.example.smarttaskmanager.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/user/{userName}/task")
    public ResponseEntity<Task> createTask(@PathVariable String userName, @RequestBody Task task) {
        Task taskNew = taskService.createTask(userName, task);
        return ResponseEntity.ok(taskNew);
    }

    @GetMapping("/user/{userName}/task/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable Long id, @PathVariable String userName) {
        Task task =  taskService.findTaskById(id, userName);
        if(task!=null) {
            return ResponseEntity.ok(task);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userName}/tasks")
    public ResponseEntity<List<Task>> getAllTasks(@PathVariable String userName) {
        List<Task> tasks = taskService.getTasksByUsername(userName);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/user/{userName}/task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @PathVariable String userName, @RequestBody Task task){
        Task taskMod = taskService.updateTask(id, userName, task);
        if (taskMod!=null) {
            return ResponseEntity.ok(taskMod);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{userName}/task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id, @PathVariable String userName){
        boolean deleted = taskService.deleteTask(id, userName);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
