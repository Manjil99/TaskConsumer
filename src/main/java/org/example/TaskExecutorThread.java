package org.example;

public class TaskExecutorThread extends Thread{
    private ThreadSafeQueue queue;
    public TaskExecutorThread(ThreadSafeQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while(true) {
            Task task = queue.remove();
            task.execute();
        }
    }
}
