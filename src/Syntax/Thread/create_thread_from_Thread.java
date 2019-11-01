package Syntax.Thread;

public class create_thread_from_Thread {
    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("스레드A");
        t1.start();

        MyThread2 t2 = new MyThread2("스레드B");
        t2.start();

    }
}

class MyThread2 extends Thread {

    public MyThread2(String name) {
        super.setName(name);
    }

    public void run() {
        System.out.println("스레드 실행 : " + Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + "종료 될 때까지 1초가 소요됩니다. 기다려 주세요...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("스레드 종료 : " + Thread.currentThread().getName());
    }

}
