package org.example;

public class Main {
    public static void main(String[] args) {
       int NO_OF_TASK = 10;
       TaskExecutorService taskExecutorService = new TaskExecutorService(new ThreadSafeQueue());
       taskExecutorService.createFixedThreadPool(5);
       for(int i=0;i<NO_OF_TASK;i++){
           taskExecutorService.submit(new FactorialCalculationTask(i,15));
           try {
               Thread.sleep(10);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }
}