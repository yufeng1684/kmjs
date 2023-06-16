package org.kmjs.java;

public class ThreadTest implements Runnable {
    private  int start;
    private  int end;
    public ThreadTest(int start, int end) {
        this.start  = start;
        this.end  = end;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum +=i;
        }
        System.out.println("the name of this thread is " + Thread.currentThread().getName() +
                ", start = " + start + ", end = " + end + ", sum is " + sum);
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest(100, 1000);
        threadTest.run();

        Thread thread1 = new Thread(new ThreadTest(200, 2000));
        thread1.start();

        Thread thread2 = new Thread(new ThreadTest(300, 2000));
        thread2.start();
    }

}
