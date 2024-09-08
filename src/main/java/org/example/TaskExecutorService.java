package org.example;

public class TaskExecutorService {
    private ThreadSafeQueue queue;
    public TaskExecutorService(ThreadSafeQueue queue){this.queue = queue;}
    public void createFixedThreadPool(int n){
        for(int i=0;i < n;i++){
            new TaskExecutorThread(queue).start();
        }
    }
    public void submit(Task task){
        queue.add(task);
    }
}
