package Syntax.Thread;

public class Synchronize extends Thread {
    public static void main(String[] args) {
        SynchronizedCounter data = new SynchronizedCounter();
        Thread p = new Producer(data);
        Thread c = new Consumer(data);

        p.start();
        c.start();
    }
}

class SynchronizedCounter {

    private int c = 0;

    // stack 값의 동기화를 위해 synchronized를 통해 락을 걸음
    public void increment(){
        c++;
    }

    public synchronized void increment2() {
        c++;
    }

    public synchronized void decrement() throws InterruptedException {
        c--;

        // Thread.sleep(1000);
    }

    public synchronized int value() {
        return c;
    }
}

class Producer extends Thread {
    SynchronizedCounter data;

    public Producer(SynchronizedCounter data) {
        this.data = data;
    }

    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.print("생산자 : ");
            data.increment2();
            System.out.println(data.value());

        }
    }
}

class Consumer extends Thread {
    SynchronizedCounter data;

    public Consumer(SynchronizedCounter data) {
        this.data = data;
    }

    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.print("소비자 : ");
            data.increment2();
            System.out.println(data.value());

        }
    }
}
