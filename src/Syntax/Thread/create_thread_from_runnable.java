package Syntax.Thread;

public class create_thread_from_runnable {
    public static void main(String args[]) {
        Thread t1 = new Thread(new MyThread(), "스레드A");
        t1.start();

        Thread t2 = new Thread(new MyThread(), "스레드B");
        t2.start();
    }

}

class MyThread implements Runnable {

    public void run() {
        System.out.println("스레드 실행 : " + Thread.currentThread().getName());

        System.out.println(Thread.currentThread().getName() + " 종료 될 때까지 3초가 소요됩니다. 기다려 주세요...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("스레드 종료 : " + Thread.currentThread().getName());
    }
}