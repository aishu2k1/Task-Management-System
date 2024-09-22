package com.example.smarttaskmanager.Service;

import com.example.smarttaskmanager.Model.Task;
import com.example.smarttaskmanager.Model.User;
import com.example.smarttaskmanager.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(String userName, Task task){
        User user = new User();
        user.setUserName(userName);
        task.setUser(user);
        return taskRepository.save(task);
    }

    public Task findTaskById(Long id, String userName){
        return taskRepository.findById(id).map(task -> {
            if(task.getUser().getUserName().equals(userName)){
                return task;
            }
            return null;
        }).orElse(null);
    }

    public List<Task> getTasksByUsername(String username){
        return taskRepository.findAllByUser_UserName(username).orElse(null);
    }

    public Task updateTask(Long id, String userName, Task taskMod){
        return taskRepository.findById(id).map(task -> {
            if(task.getUser().getUserName().equals(userName)){
                task.setName(taskMod.getName());
                task.setDescription(taskMod.getDescription());
                task.getCategory().setId(taskMod.getCategory().getId());
                return taskRepository.save(task);
            }
            return null;
        }).orElse(null);
    }

    public boolean deleteTask(Long id, String userName){
        return taskRepository.findById(id).map(task -> {
            if(task.getUser().getUserName().equals(userName)){
                taskRepository.deleteById(id);
                return true;
            }
            return false;
        }).orElse(false);
    }

    public boolean completeTask(Long id, String userName) {
        return taskRepository.findById(id).map(task -> {
            if(task.getUser().getUserName().equals(userName)){
                task.setStatus(true);
                return true;
            }
            return false;
        }).orElse(false);
    }

}
