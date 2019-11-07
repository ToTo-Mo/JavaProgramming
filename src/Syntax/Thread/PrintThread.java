package Syntax.Thread;

public class PrintThread extends Thread {
    private String threadName;
    private Object sharedObject;

    PrintThread(String name, Object shared) {
        threadName = name;
        sharedObject = shared;
    }

    PrintThread(String name) {
        threadName = name;
    }

    public void run() {
        synchronized(sharedObject){printCount();}
        // printCount();
        System.out.println("스레드 " + threadName + " 종료");
    }

    public void printCount() {
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println(threadName + " : Counter --- " + i);
            }
        } catch (Exception e) {
            System.out.println(threadName + " : 스레드 인터럽트 됨");
        }
    }

    public static void main(String[] args) {
        Object sharedObj = new Object();
        PrintThread T1 = new PrintThread("스레드 A",sharedObj);
        PrintThread T2 = new PrintThread("스레드 B",sharedObj);
        T1.start();
        T2.start();
        try {
            T1.join();
            T2.join();
        } catch (Exception e) {
            System.out.println("인터럽트 걸림");
        }
    }

}