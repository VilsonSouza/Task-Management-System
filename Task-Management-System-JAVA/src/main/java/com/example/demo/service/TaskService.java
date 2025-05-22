package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Task;

public interface TaskService {
    Task createTask(Task task);
    Task getTaskById(Long id);
    List<Task> getAllTasks();
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
    List<Task> filterTasksByStatus(String status);
    List<Task> filterTasks(String status, Long userId, String priority);
    List<Task> filterTasksByUserId(Long userId);
    List<Task> filterTasksByPriority(String priority);
}