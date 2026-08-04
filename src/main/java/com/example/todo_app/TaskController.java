package com.example.todo_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.NoSuchElementException;


@RestController
public class TaskController {
    private final TaskService taskService;

   public TaskController(TaskService taskService) {
        this.taskService = taskService;
   }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
       return taskService.findAll();
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task newTask) {

        return taskService.create(newTask.getTitle(), newTask.getPriority());
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id) {
        return taskService.complete(id);
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.delete(id);
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