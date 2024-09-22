package com.example.smarttaskmanager.Service;

import com.example.smarttaskmanager.Model.Habit;
import com.example.smarttaskmanager.Model.HabitCalendar;
import com.example.smarttaskmanager.Repository.HabitCalendarRepository;
import com.example.smarttaskmanager.Repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HabitCalendarService {

    @Autowired
    private HabitCalendarRepository habitCalendarRepository;

    @Autowired
    private HabitRepository habitRepository;

    public Optional<List<Date>> getHabitDates(Long habit_id){
        List<HabitCalendar> habits = habitCalendarRepository.findAllByHabit_Id(habit_id).orElse(null);
        return Optional.of(habits.stream().map(habitCalendar -> {
            return habitCalendar.getDate();
        }).toList());
    }

    public Map<Long, List<Date>> getAllHabitsDates(String user_name){
        List<HabitCalendar> habits = habitCalendarRepository.findAllByHabit_User_UserName(user_name).orElse(null);

        return habits.stream().collect(Collectors.groupingBy(habitCalendar -> {
            return habitCalendar.getHabit().getId();
        }, Collectors.mapping(HabitCalendar::getDate, Collectors.toList())));
    }

    public HabitCalendar addHabitDate(HabitCalendar habitEntry, Long habit_id){
        Optional<Habit> habit = habitRepository.findById(habit_id);
        habitEntry.setHabit(habit.orElse(null));
        return habitCalendarRepository.save(habitEntry);
    }

    public Boolean deleteHabitDate(HabitCalendar habitEntry, Long habit_id){
        return habitCalendarRepository.deleteByHabit_IdAndDate(habit_id, habitEntry.getDate());
    }
}
