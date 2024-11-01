package com.example.smarttaskmanager.Controller;

import com.example.smarttaskmanager.Model.Habit;
import com.example.smarttaskmanager.Service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class HabitController {

    @Autowired
    private HabitService habitService;

    @PostMapping("/users/{user_name}/habit")
    public ResponseEntity<Habit> createHabit(@PathVariable String user_name, @RequestBody Habit habit) {
        Habit habitNew = habitService.createHabit(user_name, habit);
        return ResponseEntity.ok(habitNew);
    }

    @GetMapping("/users/{user_name}/habits/{id}")
    public ResponseEntity<Habit> findHabitById(@PathVariable Long id, @PathVariable String user_name) {
        Habit habit =  habitService.findHabitById(id, user_name);
        if(habit!=null) {
            return ResponseEntity.ok(habit);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/users/{user_name}/habits")
    public ResponseEntity<List<Habit>> getAllHabits(@PathVariable String user_name) {
        List<Habit> habits = habitService.getHabitsByUsername(user_name);
        return ResponseEntity.ok(habits);
    }

    @PutMapping("/users/{user_name}/habit/{id}")
    public ResponseEntity<Habit> updateHabit(@PathVariable Long id, @PathVariable String user_name, @RequestBody Habit habit){
        Habit habitMod = habitService.updateHabit(id, user_name, habit);
        if (habitMod!=null) {
            return ResponseEntity.ok(habitMod);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/{user_name}/habit/{id}")
    public ResponseEntity<String> deleteHabit(@PathVariable Long id, @PathVariable String user_name){
        boolean deleted = habitService.deleteHabit(id, user_name);
        if (deleted) {
            return ResponseEntity.ok("Successfully deleted");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
