package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.InMemoryTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final InMemoryTaskRepository taskRepository;
    private final AiPriorityService aiPriorityService;

    public TaskService(InMemoryTaskRepository taskRepository, AiPriorityService aiPriorityService) {
        this.taskRepository = taskRepository;
        this.aiPriorityService = aiPriorityService;
    }

    public Task createTask(String title, String description) {
        String[] aiResult = aiPriorityService.getPriorityAndReasoning(title, description);
        String priority = aiResult[0];
        String reasoning = aiResult[1];

        Task task = new Task(
            UUID.randomUUID().toString(),  
            title,
            description,
            "pending",                     
            priority,                      
            reasoning                      
        );

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task markAsCompleted(String id) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus("completed");
            return task;
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }
}