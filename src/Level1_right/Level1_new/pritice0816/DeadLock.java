package Level1_right.Level1_new.pritice0816;

public class DeadLock {
    private static final String obj1 = "obj1";
    private static final String obj2 = "obj2";

    public static void main(String[] args) {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }

    public static class Thread1 extends Thread {
        public void run() {
            System.out.print("Thread1 is running");
            try {
                synchronized (obj1) {
                    System.out.print("Thread 1 get obj1");
                    sleep(300);
                    synchronized (obj2) {
                        System.out.print("Thread1 get obj2");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Thread2 extends Thread {
        public void run() {
            System.out.print("Tread2 is running");
            try {
                synchronized (obj2) {
                    System.out.print("Thread2 get obj2");
                    synchronized (obj1) {
                        System.out.print("Thread2 get obj1");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
