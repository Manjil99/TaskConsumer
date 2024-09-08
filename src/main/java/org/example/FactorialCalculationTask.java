package org.example;

public class FactorialCalculationTask extends Task{
    private int target;
    FactorialCalculationTask(int id,int target){
        super(id);
        this.target = target;
    }
    @Override
    public void execute() {
        System.out.println(Thread.currentThread() + "Starting Task - " + id);
        long ans = 1;
        for(int i = 1; i <= this.target;i++){
            ans *= i;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread() + "Finished Task - " + id + " with result " + ans);
    }
}
