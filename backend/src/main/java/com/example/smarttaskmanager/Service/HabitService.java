package com.example.smarttaskmanager.Service;

import com.example.smarttaskmanager.Model.Habit;
import com.example.smarttaskmanager.Model.User;
import com.example.smarttaskmanager.Repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    public Habit createHabit(String userName, Habit habit) {
        User user = new User();
        user.setUserName(userName);
        habit.setUser(user);
        return habitRepository.save(habit);
    }

    public Habit findHabitById(Long id, String userName) {
        return habitRepository.findById(id).map( habit -> {
            if(habit.getUser().getUserName().equals(userName)) {
                return habit;
            }
            return null;
        }).orElse(null);
    }

    public List<Habit> getHabitsByUsername(String username){
        return habitRepository.findAllByUser_UserName(username).orElse(null);
    }

    public Habit updateHabit(Long id, String userName, Habit habitNew) {
        return habitRepository.findById(id).map(habit -> {
            if(habit.getUser().getUserName().equals(userName)) {
                if(habitNew.getName() != null) {
                    habit.setName(habitNew.getName());
                }
                if(habitNew.getDescription() != null) {
                    habit.setDescription(habitNew.getDescription());
                }
                if(habitNew.getStartTime() != null) {
                    habit.setStartTime(habitNew.getStartTime());
                }
                if(habitNew.getEndTime() != null) {
                    habit.setEndTime(habitNew.getEndTime());
                }
                return habitRepository.save(habit);
            }
            return null;
        }).orElse( null);
    }

    public boolean deleteHabit(Long id, String userName) {
        return habitRepository.findById(id).map(habit -> {
            if(habit.getUser().getUserName().equals(userName)) {
                habitRepository.deleteById(id);
                return true;
            }
            return false;
        }).orElse(false);
    }
}
