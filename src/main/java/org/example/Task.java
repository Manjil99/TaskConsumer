package org.example;

public abstract class Task {
    protected int id;
    public Task(int id){this.id = id;}
    public abstract void execute();
}
