package com.example.smarttaskmanager.Controller;

import com.example.smarttaskmanager.Model.HabitCalendar;
import com.example.smarttaskmanager.Service.HabitCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class HabitCalendarController {

    @Autowired
    private HabitCalendarService habitCalendarService;

    @GetMapping("/users/{user_name}/habit/{habit_id}/calendar")
    public ResponseEntity<List<Date>> getHabitDates(@PathVariable Long habit_id){
        Optional<List<Date>> habitDates = habitCalendarService.getHabitDates(habit_id);
        return ResponseEntity.ok(habitDates.orElse(null));
    }

    @GetMapping("/users/{user_name}/habits/calendar")
    public ResponseEntity<Map<Long, List<Date>>> getHabitsDates(@PathVariable String user_name){
        Optional<Map<Long, List<Date>>> habitDates = Optional.ofNullable(habitCalendarService.getAllHabitsDates(user_name));
        return ResponseEntity.ok(habitDates.orElse(null));
    }

    @PostMapping("/users/{user_name}/habit/{habit_id}/calendar")
    public ResponseEntity<HabitCalendar> addHabitDate(@RequestBody HabitCalendar habitEntry, @PathVariable Long habit_id){
        HabitCalendar habitCalendarNew = habitCalendarService.addHabitDate(habitEntry, habit_id);
        return ResponseEntity.ok(habitCalendarNew);
    }

    @DeleteMapping("/users/{user_name}/habit/{habit_id}/calendar")
    public ResponseEntity<String> deleteHabitDate(@RequestBody HabitCalendar habitEntry, @PathVariable Long habit_id){
        Boolean deleted = habitCalendarService.deleteHabitDate(habitEntry, habit_id);
        if (deleted) {
            return ResponseEntity.ok("Successfully deleted");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
