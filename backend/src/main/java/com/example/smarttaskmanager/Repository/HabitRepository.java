package com.example.smarttaskmanager.Repository;

import com.example.smarttaskmanager.Model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {
    Optional<List<Habit>> findAllByUser_UserName(String userName);
}
