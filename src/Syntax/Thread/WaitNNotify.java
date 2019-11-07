package Syntax.Thread;

public class WaitNNotify {
    public static void main(String[] args) throws InterruptedException {
        ThreadB newThread = new ThreadB();
        newThread.start();  //newThread와 main Thread가 동시에 실행됨
        Thread.sleep(100);  //notify가 무시됨
        synchronized (newThread) {
            try {
                System.out.println("새 스레드가 마칠 때까지 대기 중 ...");
                while(!newThread.active) 
                    newThread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("총합 : " + newThread.total);
        }

    }
}

class ThreadB extends Thread {
    int total;
    boolean active = false;
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                total += i;
            }
            active = true;
            notify();
        }
    }
}
