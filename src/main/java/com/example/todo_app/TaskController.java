package com.example.todo_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.NoSuchElementException;

@RestController
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add(new Task(1, "Изучить Spring Boot", false, Priority.HIGH));
        tasks.add(new Task(2, "Сделать первый проект", false, Priority.MEDIUM));
        tasks.add(new Task(3, "Выпить кофе", false, Priority.LOW));
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return tasks;
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task newTask) {
        if (newTask.getTitle() == null || newTask.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Поле названия не может быть пустым!");
        }
        tasks.add(newTask);
        return newTask;
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDone(true);
                return task;
            }
        }
        throw new NoSuchElementException("Задача с id " + id + " не найдена");
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable int id) {
        tasks.removeIf(task -> task.getId() == id);
        return "Задача " + id + " удалена";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}