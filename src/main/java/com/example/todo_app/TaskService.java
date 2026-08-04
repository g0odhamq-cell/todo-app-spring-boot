package com.example.todo_app;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

   public void delete(Long id) {
        if (id == null || !taskRepository.existsById(id)) {
            throw new NoSuchElementException("Такой задачи не существует!");
        }
        taskRepository.deleteById(id);
    }

   public  List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task complete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Такой задачи не существует!"));

        task.setDone(true);
        return taskRepository.save(task);
    }

    public Task create (String title, Priority priority) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Пустая строка!");
        }
        Task task = new Task(title , priority);
        return taskRepository.save(task);
    }
}
