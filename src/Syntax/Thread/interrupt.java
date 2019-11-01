package Syntax.Thread;

public class interrupt extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("잠든 상태에서 벗어남");
        } catch (InterruptedException e) {
            System.out.println("인터럽트 발생 " + e);
        }
    }

    public static void main(String args[]) {
        interrupt t1 = new interrupt();
        t1.start();
        t1.interrupt();
    }
}
