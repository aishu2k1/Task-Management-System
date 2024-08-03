package com.example.smarttaskmanager.Service;

import com.example.smarttaskmanager.Model.Task;
import com.example.smarttaskmanager.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task findTaskById(Long id){
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task taskMod){
        return taskRepository.findById(id).map(task -> {
            task.setName(taskMod.getName());
            task.setDescription(taskMod.getDescription());
            return taskRepository.save(task);
        }).orElse(null);
    }

    public boolean deleteTask(Long id){
        return taskRepository.findById(id).map(task -> {
            taskRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

}
