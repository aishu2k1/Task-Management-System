package com.example.smarttaskmanager.Repository;

import com.example.smarttaskmanager.Model.HabitCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface HabitCalendarRepository extends JpaRepository<HabitCalendar, Long> {
    Optional<List<HabitCalendar>> findAllByHabit_Id(Long habit_id);
    Optional<List<HabitCalendar>> findAllByHabit_User_UserName(String user_name);
    Boolean deleteByHabit_IdAndDate(Long habit_id, Date date);
}
