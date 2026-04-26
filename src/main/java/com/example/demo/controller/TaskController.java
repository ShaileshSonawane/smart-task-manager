package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Map<String, String> request) {
        String title = request.get("title");
        String description = request.getOrDefault("description", "");

        if (title == null || title.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Task task = taskService.createTask(title, description);
        return ResponseEntity.ok(task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> markAsCompleted(@PathVariable String id) {
        try {
            Task task = taskService.markAsCompleted(id);
            return ResponseEntity.ok(task);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}