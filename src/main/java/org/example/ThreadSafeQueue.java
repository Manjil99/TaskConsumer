package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadSafeQueue {
    private Queue<Task> queue;
    private final int CAPACITY = 3;
    public ThreadSafeQueue(){
        this.queue  = new LinkedList<>();
    }
    public synchronized void add(Task task) {
        while (queue.size() == CAPACITY){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.add(task);
        notifyAll();
    }
    public synchronized Task remove() {
        while (queue.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Task task = queue.remove();
        if(queue.size() == CAPACITY - 1)notifyAll();
        return task;
    }
}
