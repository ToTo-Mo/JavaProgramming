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

    public synchronized void increment() throws InterruptedException {
        c++;

        Thread.sleep(1000);
    }

    public synchronized void decrement() throws InterruptedException {
        c--;

        Thread.sleep(1000);
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
        System.out.println("생산자");

        try {
            data.increment();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(data.value());
    }
}

class Consumer extends Thread {
    SynchronizedCounter data;

    public Consumer(SynchronizedCounter data) {
        this.data = data;
    }

    public void run() {
        System.out.println("소비자");

        try {
            data.increment();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(data.value());
    }
}
