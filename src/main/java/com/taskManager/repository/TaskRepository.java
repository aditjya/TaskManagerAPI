package com.taskManager.repository;

import com.taskManager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository {


    public Task findByTaskId(Integer taskId);

    @Query("select a from Task a where a.dueDate < :dueDate")
    public List<Task> findAllWithDueDateBefore(@Param("dueDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date dueDate);
    public List<Task> findByStatus(String status);


    default Long findByUserId(Long userId){
        return userId;
    }

    public List<Task> getTasksForUser(Long userId) {
        return taskRepository.findByUserId(userId);
    }
}
