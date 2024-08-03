package com.example.smarttaskmanager.Repository;

import com.example.smarttaskmanager.Model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Long> {
}
