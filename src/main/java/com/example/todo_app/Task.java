package com.example.todo_app;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private String title;
    private boolean done = false;

    public Task() {

    }

    public Task(String title, Priority priority) {
        this.title = title;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public boolean isDone() {
        return done;
    }
    public Priority getPriority(){
        return priority;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    public void setTitle(String title) {this.title = title; }
    public void setPriority(Priority priority) {this.priority = priority; }

}