package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Long id, Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> filterTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public List<Task> filterTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    @Override
    public List<Task> filterTasksByPriority(String priority) {
        return taskRepository.findByPriority(priority);
    }

    @Override
    public List<Task> filterTasks(String status, Long userId, String priority) {
        return taskRepository.findAll().stream()
                .filter(task -> status == null || task.getStatus().equalsIgnoreCase(status))
                .filter(task -> userId == null || task.getUserId().equals(userId))
                .filter(task -> priority == null || task.getPriority().equalsIgnoreCase(priority))
                .collect(Collectors.toList());
    }
}
