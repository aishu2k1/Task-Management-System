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

    @PostMapping("/users/{user_name}/task")
    public ResponseEntity<Task> createTask(@PathVariable String user_name, @RequestBody Task task) {
        Task taskNew = taskService.createTask(user_name, task);
        return ResponseEntity.ok(taskNew);
    }

    @GetMapping("/users/{user_name}/task/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable Long id, @PathVariable String user_name) {
        Task task =  taskService.findTaskById(id, user_name);
        if(task!=null) {
            return ResponseEntity.ok(task);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/users/{user_name}/tasks")
    public ResponseEntity<List<Task>> getAllTasks(@PathVariable String user_name) {
        List<Task> tasks = taskService.getTasksByUsername(user_name);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/users/{user_name}/task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @PathVariable String user_name, @RequestBody Task task){
        Task taskMod = taskService.updateTask(id, user_name, task);
        if (taskMod!=null) {
            return ResponseEntity.ok(taskMod);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/{user_name}/task/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id, @PathVariable String user_name){
        boolean deleted = taskService.deleteTask(id, user_name);
        if (deleted) {
            return ResponseEntity.ok("Successfully deleted task");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
