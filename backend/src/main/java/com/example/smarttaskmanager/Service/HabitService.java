package com.example.smarttaskmanager.Service;

import com.example.smarttaskmanager.Model.Habit;
import com.example.smarttaskmanager.Repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    public Habit createHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    public Habit updateHabit(Habit habitNew) {
        return habitRepository.findById(habitNew.getId()).map(habit -> {
            habit.setName(habitNew.getName());
            habit.setDescription(habitNew.getDescription());
            habit.setStartTime(habitNew.getStartTime());
            habit.setEndTime(habitNew.getEndTime());
            return habit;
        }).orElse( habitRepository.save(habitNew));
    }

    public boolean deleteHabit(Long id) {
        return habitRepository.findById(id).map(habit -> {
            habitRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
