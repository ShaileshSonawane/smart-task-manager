package com.example.demo.repository;

import com.example.demo.model.Task;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryTaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    public Task save(Task task) {
        tasks.add(task);
        return task;
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Optional<Task> findById(String id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }

    public void update(Task task) {
        // Since we're using a reference, no action needed
        // The object is already updated in the list
    }
}